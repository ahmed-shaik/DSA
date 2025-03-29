package Linkedlist.easy;

public class FindlengthofLoop {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        Node collide = null;
        int res = -1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                res = 1;
                collide = slow;
                break;
            }
        }
        if (res == -1) {
            return 0;
        }
        Node temp = collide.next;
        while (temp != collide) {
            temp = temp.next;
            res++;
        }
        return res;
    }
}
