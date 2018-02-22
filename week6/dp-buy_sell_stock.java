public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if (A.size() == 0) return 0;
        
        int maxPrice = 0;
        int accumulated = A.get(0);
        
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > accumulated) {
                maxPrice = Math.max(maxPrice, A.get(i) - accumulated);
            } else {
                accumulated = A.get(i);
            }
        }
        
        return maxPrice;
    }
}
