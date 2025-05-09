package Linkedlist;

// import java.util.LinkedList;

public class LinkedList2 {
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

    // public void addLast(int data) {
    // Node newNode = new Node(data);
    // size++;
    // if (head == null) {
    // head = tail = newNode;
    // return;
    // }
    // tail.next = newNode;
    // tail = newNode;
    // }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // public boolean isCycle() {
    // Node fast = head;
    // Node slow = head;
    // while (fast != null && fast.next != null) {
    // fast.next = fast.next.next;
    // slow = slow.next;
    // if (fast == slow) {
    // return true;
    // }
    // }
    // return false;
    // }

    // public void removeCycle() {
    // Node fast = head;
    // Node slow = head;
    // while (fast != null && fast.next != null) {
    // slow = slow.next;
    // fast = fast.next.next;
    // if (fast == slow) {
    // break;
    // }
    // }
    // slow = head;
    // Node prev = null;
    // while (slow != fast) {
    // prev = fast;
    // slow = slow.next;
    // fast = fast.next;
    // }
    // prev.next = null;
    // }
    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node rigthHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRigth = mergeSort(rigthHead);
        return merge(newLeft, newRigth);
    }

    public Node merge(Node left, Node right) {
        Node node = new Node(-1);
        Node temp = node;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return node.next;
    }

    public void zigzag() {
        Node mid = getMid(head);
        Node prev = null, curr = mid.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid.next = null;
        Node right = prev;
        Node left = head;
        Node nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }

    public static void main(String args[]) {
        // LinkedList2 ll = new LinkedList2();
        // ll.head = new Node(1);
        // Node temp = new Node(2);
        // ll.head.next = temp;
        // ll.head.next.next = new Node(3);
        // ll.head.next.next.next = temp;
        // System.out.println(ll.isCycle());
        // ll.removeCycle();
        // ll.printList();
        // LinkedList<Integer> ll = new LinkedList<>();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addFirst(0);
        // ll.removeFirst();
        // ll.removeFirst();
        LinkedList2 ll = new LinkedList2();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printList();
        // ll.head = ll.mergeSort(ll.head);
        ll.zigzag();
        ll.printList();

        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        dll.reverse();
        dll.print();
    }
}

class DoubleLL {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node tail;
    public static Node head;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public int removeFirst(int data) {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        size--;
        if (head == tail) {
            head = tail = null;
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        return val;
    }

    public void reverse() {
        Node current = head;
        Node prev = null;
        Node nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            current.prev = nextNode;
            prev = current;
            current = nextNode;
        }
        head = prev;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}