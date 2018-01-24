/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode slow = A;
        ListNode fast = slow.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode firstHalf = A;
        ListNode secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverse(secondHalf);
        ListNode dummy = new ListNode(-1);

        ListNode ptr = dummy;
        while(firstHalf != null || secondHalf != null) {

            if (firstHalf != null) {
                ptr.next = firstHalf;
                ptr = ptr.next;
                firstHalf = firstHalf.next;
            }

            if (secondHalf != null) {
                ptr.next = secondHalf;
                ptr = ptr.next;
                secondHalf = secondHalf.next;
            }
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode A) {
        if (A == null) return null;

        ListNode p = null;
        ListNode c = A;
        ListNode n = null;

        while(c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }

        A = p;
        return p;
    }
}
