class Solution:
    # @param A : list of integers
    # @return a list of list of integers
    def permute(self, A):
        x = [[]]
        for n in A:
            x = [l[:i]+[n]+l[i:]
                   for l in x
                   for i in xrange((l+[n]).index(n)+1)]
        return x
