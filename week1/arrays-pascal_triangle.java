public class Solution {
    public int[][] generate(int A) {
        int[][] result = new int[A][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[i+1];
        }

        if (A >= 1) {
            result[0][0] = 1;
        } else {
            return result;
        }

        for (int i = 1; i < A; i++) {
            for (int j = 0; j <= i; j++) {
                if ( j==0 || j==i ) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i-1][j-1] + result[i-1][j];
                }
            }
        }

        return result;
    }
}
