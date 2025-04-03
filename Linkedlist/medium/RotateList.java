package Linkedlist.medium;

public class RotateList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        temp.next = head;
        k = k % length;
        if (k == 0) {
            temp.next = null;
            return head;
        }

        ListNode prev = head;
        for (int i = 0; i < length - k - 1; i++) {
            prev = prev.next;
        }

        ListNode newHead = prev.next;
        prev.next = null;

        return newHead;
    }
}
