/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode head = new ListNode(-1);
        ListNode Hp = head;
        ListNode Ap = A;
        ListNode Bp = B;
        int carry = 0;

        while(Ap != null || Bp != null || carry > 0) {
            int a = Ap != null ? Ap.val : 0;
            int b = Bp != null ? Bp.val : 0;

            Hp.next = new ListNode((a + b + carry) % 10);
            carry = (a + b + carry)/10;

            // we move the pointers
            Hp = Hp.next;
            if (Ap != null) Ap = Ap.next;
            if (Bp != null) Bp = Bp.next;
        }

        return head.next;
    }
}
