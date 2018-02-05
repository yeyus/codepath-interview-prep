public class Solution {
    public int numSetBits(long a) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            long val = a & (long)(1 << i);
            if (val > 0) count++;
        }
	    
        return count;
    }
}
