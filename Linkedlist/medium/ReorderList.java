// package Linkedlist.medium;

// public class ReorderList {
// /**
// * Definition for singly-linked list.
// * public class ListNode {
// * int val;
// * ListNode next;
// * ListNode() {}
// * ListNode(int val) { this.val = val; }
// * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
// */
// class Solution {
// public void reorderList(ListNode head) {
// if (head == null || head.next == null)
// return;
// ListNode slow = head, fast = head;
// while (fast != null && fast.next != null) {
// slow = slow.next;
// fast = fast.next.next;
// }
// ListNode mid = slow;

// ListNode prev = null, curr = mid.next;
// mid.next = null;
// while (curr != null) {
// ListNode next = curr.next;
// curr.next = prev;
// prev = curr;
// curr = next;
// }
// ListNode left = head;
// ListNode right = prev;
// ListNode nextL, nextR;
// while (left != null && right != null) {
// nextL = left.next;
// left.next = right;
// nextR = right.next;
// right.next = nextL;

// left = nextL;
// right = nextR;
// }
// }
// }
// }
