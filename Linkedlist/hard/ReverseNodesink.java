package Linkedlist.hard;

public class ReverseNodesink {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k == 1) {
                return head; // No need to reverse if the list is empty or k is 1
            }

            // Step 1: Calculate the length of the list
            int len = 0;
            ListNode temp = head;
            while (temp != null) {
                len++;
                temp = temp.next;
            }

            // Step 2: Initialize pointers
            ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
            dummy.next = head;
            ListNode prevGroupEnd = dummy; // This will point to the end of the previous group
            ListNode curr = head;

            // Step 3: Reverse in k-sized groups
            while (len >= k) { // Only reverse if there are enough nodes for a group
                ListNode st = curr; // Start of the current group
                ListNode prev = null; // Previous node for reversing
                ListNode next = null; // Next node for traversing

                // Reverse the current group of k nodes
                for (int i = 0; i < k; i++) {
                    next = curr.next; // Store next node
                    curr.next = prev; // Reverse the link
                    prev = curr; // Move prev to current
                    curr = next; // Move to the next node
                }

                // Connect the end of the previous group to the start of the reversed group
                prevGroupEnd.next = prev; // Connect the end of the previous group to the new head of the reversed group
                st.next = curr; // Connect the end of the reversed group to the next group

                // Move prevGroupEnd to the end of the newly reversed group
                prevGroupEnd = st;

                len -= k; // Decrease length by k after processing one group
            }

            return dummy.next; // Return the modified head of the list
        }
    }
}