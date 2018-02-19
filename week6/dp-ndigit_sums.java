public class Solution {
    public int solve(int N, int S) {
        int count[][] = new int[N][S];
        
        // 0 digits that account for sum = 0
        for (int i = 0; i < S; i++) {
            if (i+1 <= 9) {
                count[0][i] = 1;
            } else {
                count[0][i] = 0;    
            }
        }
        
        // n digits that account for 0
        for (int i = 0; i < N; i++) {
            count[i][0] = 1;
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < S; j++) {
                count[i][j] = 0;
                int k = 0;
                if (j >= 9) k = j - 9;
                for(; k <= j; k++) {
                    count[i][j] = (count[i][j] + count[i-1][k]) % 1000000007;
                }
            }
        }
        
        //System.out.print(Arrays.deepToString(count));
        
        return count[N-1][S-1];
    }
}
