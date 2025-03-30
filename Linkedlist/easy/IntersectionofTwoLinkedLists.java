package Linkedlist.easy;

public class IntersectionofTwoLinkedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int c1 = 0, c2 = 0;
        while (a != null) {
            c1++;
            a = a.next;
        }
        while (b != null) {
            c2++;
            b = b.next;
        }
        a = headA;
        b = headB;
        if (c1 < c2) {
            for (int i = 0; i < c2 - c1; i++) {
                b = b.next;
            }
        } else {
            for (int i = 0; i < c1 - c2; i++) {
                a = a.next;
            }
        }

        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
