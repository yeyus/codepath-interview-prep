public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        
        int incr[] = new int[A.size()];
        Arrays.fill(incr, 1);
        
        for(int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j) && incr[i] < incr[j] + 1) {
                    incr[i] = incr[j] + 1;
                }
            }
        }
        
        int decr[] = new int[A.size()];
        Arrays.fill(decr, 1);
        
        for(int i = A.size() - 2; i >= 0; i--) {
            for (int j = A.size() - 1; j > i; j--) {
                if (A.get(i) > A.get(j) && decr[i] < decr[j] + 1) {
                    decr[i] = decr[j] + 1;
                }
            }
        }
        
        int max = incr[0] + decr[0] - 1;
        for (int i = 1; i < A.size(); i++) {
            if (incr[i] + decr[i] - 1 > max) {
                max = incr[i] + decr[i] - 1;
            }
        }
        
        return max;
    }
}
