class Solution:
    # @param A : tuple of integers
    # @return an integer
    def longestConsecutive(self, A):
        d = {}
        m = 1
        for n in A:
            if not d.has_key(n):
                l = d[n-1] if d.has_key(n-1) else 0
                r = d[n+1] if d.has_key(n+1) else 0
                d[n] = l + r + 1
                m = max(m, l + r + 1)
                d[n - l] = l + r + 1
                d[n + r] = l + r + 1

        return m
