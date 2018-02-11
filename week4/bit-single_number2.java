public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int ones = 0, twos = 0, commonmask = 0;
        
        for (Integer i : A) {
            twos  = twos | (ones & i);
            ones  = ones ^ i;
            commonmask = ~(ones & twos);
            ones &= commonmask;
            twos &= commonmask;
        }
        
        return ones;
    }
}
