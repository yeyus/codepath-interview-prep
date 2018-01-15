class Solution:
    # @param A : list of integers
    # @return a list of integers
    def wave(self, A):
        As = sorted(A)
        result = []
        for i in xrange(len(As)/2 + 1):
            if 2*i+1 < len(As):
                result.append(As[2*i+1])
            if 2*i < len(As):
                result.append(As[2*i])

        return result
