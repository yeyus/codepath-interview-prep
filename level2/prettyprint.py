class Solution:
    # @param A : integer
    # @return a list of list of integers
    def prettyPrint(self, A):
        size = (2*A)-1
        a = [[0] * size for k in range(size)]
        for i in range(size):
            for j in range(size):
                a[i][j] = self.distanceToCenter(size, i, j)
        return a

    def distanceToCenter(self, size, i, j):
        return max(abs((size/2) - i) + 1, abs((size/2) - j) + 1)
