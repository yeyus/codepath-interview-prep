public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int acc = 0;
        for (Integer i: A) {
            acc ^= i;
        }
        
        return acc;
    }
}
