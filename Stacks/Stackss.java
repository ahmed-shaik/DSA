package Stacks;

import java.util.*;

public class Stackss {
    // Implementing using arrayList
    // static class Stack {
    // static ArrayList<Integer> list = new ArrayList<>();

    // public static boolean isEmpty() {
    // return list.size() == 0;
    // }

    // public static void push(int data) {
    // list.add(data);
    // }

    // public static int pop() {
    // if (isEmpty())
    // return -1;
    // int data = list.get(list.size() - 1);
    // list.remove(list.size() - 1);
    // return data;
    // }

    // public static int peek() {
    // if (isEmpty())
    // return -1;
    // return list.get(list.size() - 1);
    // }
    // }

    // Implementing using LinkedList
    // static class Node {
    // int data;
    // Node next;

    // Node(int data) {
    // this.data = data;
    // this.next = null;
    // }
    // }

    // static class Stack {
    // static Node head = null;

    // public static boolean isEmpty() {
    // return head == null;
    // }

    // public static void push(int data) {
    // Node newNode = new Node(data);
    // if (isEmpty()) {
    // head = newNode;
    // return;
    // }
    // newNode.next = head;
    // head = newNode;
    // }

    // public static int pop() {
    // if (isEmpty()) {
    // return -1;
    // }
    // int data = head.data;
    // head = head.next;
    // return data;
    // }

    // public int peek() {
    // if (isEmpty()) {
    // return -1;
    // }
    // return head.data;
    // }
    // }

    // Push at the Bottom of the Stack
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // reverse a stack using stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void stockSpan(int[] stock, int[] span) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;
        for (int i = 1; i < stock.length; i++) {
            while (!s.isEmpty() && stock[s.peek()] <= stock[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    public static void nextGreaterElement(int[] arr, int[] greater) {
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                greater[i] = -1;
            } else {
                greater[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    public static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.peek();
                if ((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean duplicateParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ')') {
                stack.push(ch);
            } else {
                int count = 0;
                while (stack.peek() != '(') {
                    stack.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    stack.pop();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // stack - LIFO - Last In First Out
        // stack - push - pop - peek - isEmpty - size
        // Stack s = new Stack();
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(2);
        s.push(1);
        // pushAtBottom(s, 4);
        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // System.out.println("Reversed String: " + reverseString("racecar"));

        // reverseStack(s);
        // while (!s.isEmpty()) {
        // System.out.println(s.peek());
        // s.pop();
        // }

        // stock span problem - next greater element to left - next greater element to
        // right
        // int[] stock = { 100, 80, 60, 70, 60, 85, 100 };
        // int[] span = new int[stock.length];
        // stockSpan(stock, span);
        // for (int i = 0; i < span.length; i++) {
        // System.out.print(span[i] + " ");
        // }

        // next greater element
        // int arr[] = { 6, 8, 0, 1, 3 };
        // int greater[] = new int[arr.length];
        // nextGreaterElement(arr, greater);

        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(greater[i] + " ");
        //  }

        // System.out.println(validParentheses("(){}[]"));
        // System.out.println(validParentheses("({[()]})"));
        //  System.out.println(validParentheses("((((()"));

        System.out.println(duplicateParentheses("((a+b))"));

        System.out.println(duplicateParentheses("(a-b)"));

    }

}
