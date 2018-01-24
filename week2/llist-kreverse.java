/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        ListNode dummy = new ListNode(0), start = dummy;
        dummy.next = A;
        while(true) {
            ListNode p = start, c, n = p;
            start = p.next;
            for(int i = 0; i < B && n != null; i++) n = n.next;
            if(n == null) break;
            for(int i = 0; i < B-1; i++) {
                c = p.next;
                p.next = c.next;
                c.next = n.next;
                n.next = c;
            }
        }
        
        ListNode root = dummy.next;
        
        while(root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
        
        return null;
    }
}
