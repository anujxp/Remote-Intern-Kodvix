package org.example;

class SharedResource {
    private int data;
    private boolean hasData = false; // Flag to track if data is available

    // Produced by Thread A
    public synchronized void produce(int value) {
        while (hasData) { // If data is already there, wait for consumer
            try {
                wait(); // Thread releases the lock and pauses
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.data = value;
        this.hasData = true;
        System.out.println("Produced: " + value);
        notifyAll(); // Wake up the consumer thread
    }

    // Consumed by Thread B
    public synchronized int consume() {
        while (!hasData) { // If no data, wait for producer
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify(); // Wake up the producer thread
        return data;
    }
}

public class ThreadCommunicationDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Producer Thread
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.produce(i);
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}