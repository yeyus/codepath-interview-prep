import java.math.BigInteger;

public class Solution {
    public int pow(int x, int n, int d) {
        long result = pow2(x, n, d) % d;
        if (result < 0) {
            result += d;
        }
        return Math.toIntExact(result);
    }
	
    public long pow2(int x, int n, int d) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n % 2 == 0) {
            long p = pow2(x, n/2, d);
            return (p*p)%d;
        } else {
            int k = x % d;
            if(k < 0){
                k += d;
            }
            return (k * pow2(x, n-1, d)) % d;
        }
    }
}
