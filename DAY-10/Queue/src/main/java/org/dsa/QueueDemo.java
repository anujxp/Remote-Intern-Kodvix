package org.dsa;

public class QueueDemo {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.insert(10);
        q.insert(20);
        q.display();
        System.out.print("Peek element is : "); q.peek();
    }
}
