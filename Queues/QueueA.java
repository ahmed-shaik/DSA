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

    static class StackUsingQueue {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void printNonRepeating(String s) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void interleavingQueue(Queue<Integer> q) {
        Queue<Integer> first = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            first.add(q.remove());
        }
        while (!first.isEmpty()) {
            q.add(first.remove());
            q.add(q.remove());
        }
    }

    public static void printQueue(Queue<Integer> q) {
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }

    public static void reverseUsingStack(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void reverseUsingRecursion(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int top = q.remove();
        reverseUsingRecursion(q);
        q.add(top);
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

        // QueueUsingStacks q = new QueueUsingStacks();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        // System.out.println(q.peek());
        // q.remove();
        // }

        // StackUsingQueue s = new StackUsingQueue();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // String str = "aabccxb";
        // printNonRepeating(str);

        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);
        // // interleavingQueue(q);
        // // reverseUsingStack(q);
        // reverseUsingRecursion(q);
        // printQueue(q);

        // Deque - double ended queue operations👇

        // addFirst( )
        // addLast( )
        // removeFirst( )
        // removeLast( )
        // getLast( )
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        System.out.println(d);
    }
}
