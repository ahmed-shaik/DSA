package Linkedlist;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
        }
        int i = 0;
        Node temp = head;
        while (index < i - 1) {
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(data);
        size++;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;

    }

    public int removeLast() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = tail.data;
            tail = head = null;
            size--;
            return val;
        }
        int val = tail.data;
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        tail = temp;
        temp.next = null;
        size--;
        return val;
    }

    public int itrSearch(int key) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    // public int recSearch(int i, Node temp, int key) {
    // if (temp.data == key) {
    // return i;
    // } else if (temp.next == null) {
    // return -1;
    // }
    // return recSearch(i + 1, temp.next, key);
    // }
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        } else {
            return idx + 1;
        }
    }

    public int recSearch(int i, Node temp, int key) {
        return helper(head, key);
    }

    public void itrRev() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthNodeFromEnd(int n) {
        if (n == size) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        int idx = size - n;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome() {
        // 1 - find mid
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = findMid(head);
        // 2 - reverse second half
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 3 - compare first half and second half
        Node first = head;
        Node second = prev;
        while (second != null) {
            if (first.data != second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(0);
        // ll.add(1, 1);
        // ll.printList();
        // ll.removeLast();
        // ll.printList();
        // System.out.println(ll.itrSearch(5));
        // System.out.println(ll.recSearch(0, head, 9));
        // ll.itrRev();
        // ll.printList();
        // ll.deleteNthNodeFromEnd(3);
        ll.addFirst(1);
        ll.addFirst(7);
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(1);
        ll.printList();
        System.out.println(ll.checkPalindrome());
    }
}
