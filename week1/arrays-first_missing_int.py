class Solution:
    # @param A : list of integers
    # @return an integer
    def firstMissingPositive(self, A):
        B = sorted(A)
        # find max
        mx = max(B[len(B) - 1], 0)
        if mx == 0:
            return 1

        # finx first min > 0
        mn = mx
        pmn = -1
        for i in xrange(len(B)):
            if B[i] > 0:
               mn = min(mn, B[i])
               if mn == B[i]:
                   pmn = i
        if mn > 1:
            return 1

        missing = 1
        for i in xrange(pmn, len(B)):
            if B[i] != missing:
                return missing
            else:
                missing += 1

        return mx + 1
