public class Solution {
    public long reverse(long a) {
        for (int i = 0; i < 16; i++) {
            int r = 31 - i;
            long b = (a >> i) & 1;
            long br = (a >> r) & 1;
            long x = b ^ br;
            x = (x << i) | (x << r);
            a ^= x;
            //System.out.printf("i:%d r: %d a:%s b:%s br:%s\n", i, r, Long.toString(a,2), Long.toString(b,2), Long.toString(br,2));
        }
	    
        return a;
    }

}
