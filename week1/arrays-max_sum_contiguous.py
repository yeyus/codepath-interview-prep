class Solution:
    # @param A : tuple of integers
    # @return an integer
    def maxSubArray(self, A):
        max_up_to = max_total = A[0]
        for x in A[1:]:
            max_up_to = max(x, x + max_up_to)
            max_total = max(max_total, max_up_to)
            
        return max_total
