package com.dsa;

import java.util.Scanner;

class StackChar {
    private char[] stack;
    private int top;
    private int size;

    public StackChar(int size) {
        stack = new char[size];
        this.size = size;
        top = -1;
    }

    public void push(char data) {
        if (top == size - 1) {
            System.out.println("Stack overflow");
            return;
        }
        stack[++top] = data;
    }

    public char pop() {
        if (top == -1) {
            System.out.println("Stack UnderFlow");
            return '0';
        }
        return stack[top--];
    }

    public char peek() {
        return stack[top];
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack UnderFlow");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public int countVowel() {
        if (top == -1) {
            return 0;
        }
        int count = 0;
        for (int i = top; i >= 0; i--) {
            char current = Character.toLowerCase(stack[i]);
            if (current == 'a' || current == 'e' || current == 'i' ||
                    current == 'o' || current == 'u') {
                count++;
            }
        }
        return count;
    }
    public int countConsonants() {
        int count = 0;
        for (int i = top; i >= 0; i--) {
            char ch = Character.toLowerCase(stack[i]);
            if (ch >= 'a' && ch <= 'z') {
                if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')) {
                    count++;
                }
            }
        }
        return count;
    }
    public int countSpecialChars() {
        int count = 0;
        for (int i = top; i >= 0; i--) {
            char ch = stack[i];
            if (!( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') ) && "+-*/%=".indexOf(ch) == -1) {
                count++;
            }
        }
        return count;
    }
    public int countOperators() {
        int count = 0;
        String operators = "+-*/%^=";
        for (int i = top; i >= 0; i--) {
            if (operators.indexOf(stack[i]) != -1) {
                count++;
            }
        }
        return count;
    }
}

    public class Stack2 {
        public static void main(String[] args) {
            int choice = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the size of the stack");
            int size = sc.nextInt();
            StackChar stack = new StackChar(size);
            do {
                System.out.println("-------------------------------------------");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Display");
                System.out.println("4.peek");
                System.out.println("5. Count Vowel");
                System.out.println("6 . Count Consonent");
                System.out.println("7. count special carecter ");
                System.out.println("8. Count operator");
                System.out.println("9. Exit");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the data");
                        stack.push((char)sc.next().charAt(0));
                        break;
                    case 2:
                        System.out.println("The Poped Item is " + stack.pop());
                        break;
                    case 3:
                        stack.display();
                        break;
                    case 4:
                        System.out.println(stack.peek());
                        break;
                    case 5:
                        System.out.println("Count Vowel "+ stack.countVowel());
                        break;
                    case 6:
                        System.out.println("Count Consonants "+ stack.countConsonants());
                        break;
                    case 7:
                        System.out.println("Count SpecialCharecters "+ stack.countSpecialChars());
                        break;
                    case 8:
                        System.out.println("Count Operators "+ stack.countOperators());
                        break;
                    case 9:
                        System.exit(0);
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            } while (choice != 8);
        }
    }
