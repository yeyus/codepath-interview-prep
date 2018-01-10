class Solution:
    # @param A : list of integers
    # @param B : integer
    # @param C : integer
    # @return an integer
    def numRange(self, A, B, C):
        s = 0
        for i in range(len(A)):
            j = i+1
            while  j <= len(A):
                sm = sum(A[i:j])
                #print '{} ({}:{}) = {}'.format(A[i:j], i, j, sm)
                if sm >= B and sm <= C:
                    s += 1
                    j += 1
                elif sm < B:
                    j += 1
                elif sm > C:
                    break
        return s
