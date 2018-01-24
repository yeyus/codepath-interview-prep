/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        int size = getSize(A);
        ListNode ptr = A;
        ListNode ptr2 = A;
        
        if (size == 1) {
            return 1;
        }
        
        int halfth = size % (size/2) == 1 ? (size/2) + 1: (size/2);
        for (int i = 0; i < size; i++) {
            if (i == halfth) {
                ptr = reverse(ptr);
            }
            
            if (i >= halfth) {
                if (ptr.val != ptr2.val) {
                    return 0;
                }
                ptr2 = ptr2.next;
            }
            
            ptr = ptr.next;
        }
        
        return 1;
    }
    
    public int getSize(ListNode A) {
        int count = 0;
        ListNode head = A;
        
        while(head != null) {
            count++;
            head = head.next;
        }
        
        return count;
    }
    
    public ListNode reverse(ListNode A) {
        ListNode prev = null;
        ListNode current = A;
        ListNode next;
        while (current != null) 
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}
