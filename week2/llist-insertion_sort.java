/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        ListNode head = A;
        ListNode ptr = A.next;
        ListNode cptr = A;
        while(ptr != null) {
            while(cptr != ptr) {
                if (ptr.val < cptr.val) {
                    swap(ptr, cptr);
                } else {
                    cptr = cptr.next;
                }
            }
            cptr = head;
            ptr = ptr.next;
        }

        return head;
    }

    public void swap(ListNode A, ListNode B) {
        int tmp = A.val;
        A.val = B.val;
        B.val = tmp;
    }
}
