// package Linkedlist.medium;

// public class RemoveNodesFromLinkedList {
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
// public ListNode removeNodes(ListNode head) {
// if(head.next == null){
// return head;
// }
// ListNode prevNode = head;
// ListNode currentNode = head.next;

// while(currentNode != null){
// ListNode nextNode = currentNode.next;
// currentNode.next = prevNode;
// prevNode = currentNode;
// currentNode = nextNode;
// }
// head.next = null;
// head = prevNode;

// prevNode = head;
// currentNode = head.next;
// while(currentNode != null){
// if(currentNode.val < prevNode.val){
// currentNode = currentNode.next;
// }
// else{
// ListNode nextNode = currentNode.next;
// currentNode.next = prevNode;
// prevNode = currentNode;
// currentNode = nextNode;
// }

// }
// head.next = null;
// head = prevNode;
// return head;
// }
// }
// }
