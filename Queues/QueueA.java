package Queues;

import java.util.*;

public class QueueA {
    // Queue - fifo
    // front - eit
    // rear -entry
    // operatinos
    // add(enque) - O(1)
    // remove(deque) - O(1)
    // peek - O(1)
    static class ArrQueue {
        // using array
        static int arr[];
        static int size;
        static int rear;

        ArrQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static void add(int num) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            arr[++rear] = num;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queeu is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queeu is empty");
                return -1;
            }
            return arr[0];
        }
    }

    static class CircularQueue {
        // using array
        static int arr[];
        static int size;
        static int rear;
        static int front;

        CircularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int num) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = num;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queeu is empty");
                return -1;
            }
            int f = arr[front];
            if (rear == front) {
                rear = front = -1;
                return -1;
            } else {
                front = (front + 1) % size;
            }
            return f;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queeu is empty");
                return -1;
            }
            return arr[front];
        }
    }

    // to implement using Linked lists
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedQueue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("cant remove");
                return -1;
            }
            int data = head.data;
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue Empty");
                return -1;
            }
            return head.data;
        }

    }

    static class QueueUsingStacks {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (isEmpty()) {
                return -1;
            }
            return s1.pop();
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        // LinkedQueue q = new LinkedQueue();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        // System.out.println(q.peek());
        // q.remove();
        // }

        // Using java collection framework
        // Queue<Integer> q = new LinkedList<>(); // ArrayDeque
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        // System.out.println(q.remove());
        // }

        QueueUsingStacks q = new QueueUsingStacks();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
