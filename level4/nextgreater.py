class Solution:
    # @param A : list of integers
    # @return a list of integers
    def nextGreater(self, A):
        R = []
        for i in range(len(A)):
            for j in range(i,len(A)):
                #print 'i:{} j:{} A[i]:{} A[j]:{} len(A):{}'.format(i, j, A[i], A[j], len(A))
                if A[j] > A[i]:
                    R.append(A[j])
                    break
                elif A[j] <= A[i] and j == (len(A)-1):
                    R.append(-1)
                elif j == len(A):
                    R.append(-1)
        return R
