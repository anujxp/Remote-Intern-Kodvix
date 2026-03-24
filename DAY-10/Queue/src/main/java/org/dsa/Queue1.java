package org.dsa;

import java.util.Scanner;

class Queue02 {
    int queue[];
    int f, r;
    int size;

    Queue02(int size) {
        this.size = size;
        this.queue = new int[size];
        this.f = -1;
        this.r = -1;
    }

    void insert(int x) {
        if ((r + 1)  == size) {
            System.out.println("Queue is full");
            return;
        }
        if (f == -1) {
            f = 0;
        }
        r = (r + 1);
        queue[r] = x;
        System.out.println("Inserted: " + x);
    }

    void delete() {
        if (f == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Deleted: " + queue[f]);
        if (f == r) {
            f = -1;
            r = -1;
        } else {
            f = (f + 1);
        }
    }

    void display() {
        if (f == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        int i = f;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == r) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    void countPrime() {
        if (f == -1) {
            System.out.println("Prime numbers: 0");
            return;
        }
        int count = 0;
        int i = f;
        while (true) {
            if (isPrime(queue[i])) count++;
            if (i == r) break;
            i = (i + 1);
        }
        System.out.println("Prime numbers: " + count);
    }

    void countPerfect() {
        if (f == -1) {
            System.out.println("Perfect numbers: 0");
            return;
        }
        int count = 0;
        int i = f;
        while (true) {
            if (isPerfect(queue[i])) count++;
            if (i == r) break;
            i = (i + 1) % size;
        }
        System.out.println("Perfect numbers: " + count);
    }

    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    boolean isPerfect(int n) {
        if (n <= 1) return false;
        int sum = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }
}

class Queue1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of queue: ");
        int n = sc.nextInt();
        Queue02 q = new Queue02(n);
        int choice, val;

        do {
            System.out.println("\n--- CIRCULAR QUEUE MENU ---");
            System.out.println("1. Insert\n2. Delete\n3. Display\n4. Count Primes\n5. Count Perfect\n6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    q.insert(val);
                    break;
                case 2:
                    q.delete();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    q.countPrime();
                    break;
                case 5:
                    q.countPerfect();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 6);
        sc.close();
    }
}