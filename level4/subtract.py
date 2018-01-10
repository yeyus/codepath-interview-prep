# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param A : head node of linked list
    # @return the head node in the linked list
    def subtract(self, A):
        size = self.getSize(A)
        if size == 1:
            return A

        head = A
        if size % 2 == 0:
            prev_hptr = self.move(A, size/2 -1)
            hptr = self.move(A, size/2)
        else:
            prev_hptr = self.move(A, size/2)
            hptr = self.move(A, size/2 +1)
        prev_hptr.next = self.reverse(hptr)
        #print "{} {}".format(hptr.val, newhptr.val)

        sub_head_ptr = head
        sub_center_ptr = prev_hptr.next
        while sub_center_ptr != None:
            sub_head_ptr.val = sub_center_ptr.val - sub_head_ptr.val
            sub_center_ptr = sub_center_ptr.next
            sub_head_ptr = sub_head_ptr.next

        prev_hptr.next = self.reverse(prev_hptr.next)
        return A

    def move(self, A, maxSteps):
        ptr = A
        steps = 0
        while ptr != None and steps < maxSteps:
            ptr = ptr.next
            steps += 1
        return ptr

    def reverse(self, A):
        curr = A
        prev = None
        while curr != None:
            t = curr.next
            curr.next = prev
            prev = curr
            curr = t
        return prev

    def getSize(self, A):
        size = 0
        ptr = A
        while ptr != None:
            size += 1
            ptr = ptr.next
        return size
