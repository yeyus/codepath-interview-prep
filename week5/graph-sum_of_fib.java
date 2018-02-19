public class Solution {
    public int fibsum(int A) {
        //System.out.printf(" fibsum(%d) ", A);
        if (A == 0) {
            return 0;
        }
        
        int prevN1 = 1;
        int prevN2 = 0;
        
        while(prevN1 <= A) {
            int nprev = prevN1 + prevN2;
            prevN2 = prevN1;
            prevN1 = nprev;
        }
        
        //System.out.printf("[prevN2: %d]", prevN2);
        
        return 1 + fibsum(A - prevN2);
    }
}
