// package Linkedlist.easy;

// public class PalindromeLinkedList {
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
// public boolean isPalindrome(ListNode head) {
// if (head == null || head.next == null) {
// return true;
// }
// ListNode slow=head;
// ListNode fast=head;
// while(fast!=null && fast.next!=null) {
// slow=slow.next;
// fast = fast.next.next;
// }
// ListNode mid = slow;
// ListNode prev=null;
// ListNode curr=mid;
// ListNode next;
// while(curr!=null) {
// next = curr.next;
// curr.next = prev;
// prev = curr;
// curr = next;
// }
// curr = head;
// ListNode head2 = prev;
// while(head2!=null) {
// if(curr.val != head2.val) {
// return false;
// }
// curr = curr.next;
// head2 = head2.next;
// }
// return true;
// }
// }
// }
