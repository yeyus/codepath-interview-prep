public class Solution {
    public int sqrt(int a) {
        long start = 0;
        long end = a;
        long aniza = a;
	    
        if (a == 1) return 1;
	    
        while (end - start > 1) {
            long middle = (start + end)/2;
            //System.out.printf("[start: %d end: %d middle: %d middle**2: %d]", start, end, middle, middle*middle);
            if (pow2(middle) > aniza) {
                end = middle;
            } else {
                start = middle;
            }
        }
	    
        return Math.toIntExact(start);
    }
	
    public long pow2(long x) {
        return x * x;
    }
}
