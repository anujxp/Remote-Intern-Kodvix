package com.dsa;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head = null;

    public void add(int data) {
        Node newNode = new Node(data);
        Node current = head;
        if (head == null)
            head = newNode;
        else {
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
    }

    public void printValues() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void delete(int data){
        Node current = head;
        while(current.next!= null && current.next.data != data){
            current = current.next;
        }
        if(current.next != null)
            current.next  = current.next.next;
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList nums = new LinkedList();
        nums.add(4);
        nums.add(5);
        nums.add(5);
        nums.add(6);
        nums.add(3);
        nums.printValues();
        nums.delete(6);
        nums.printValues();

    }
}
