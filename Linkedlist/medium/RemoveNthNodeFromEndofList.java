package Linkedlist.medium;

// Given the head of a linked list, remove the nth node from the end of the list and return its head.
public class RemoveNthNodeFromEndofList {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        // public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode temp = head;
        // int len = 0;
        // while (temp != null) {
        // len++;
        // temp = temp.next;
        // }
        // if (n == len) {
        // head = head.next;
        // return head;
        // }
        // temp = head;
        // for (int i = 0; i < len - n - 1; i++) {
        // temp = temp.next;
        // }
        // temp.next = temp.next.next;
        // return head;
    }

    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast = dummy;
            ListNode slow = dummy;
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }

}
