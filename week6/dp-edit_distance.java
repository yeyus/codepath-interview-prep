public class Solution {
    public int minDistance(String A, String B) {
        int al = A.length();
        int bl = B.length();
        
        int[][] aux = new int[al+1][bl+1];
        // base cases
        for (int i = 0; i <= al; i++) {
            aux[i][0] = i;
        }
        for (int i = 0; i <= bl; i++) {
            aux[0][i] = i;
        }
        
        for (int i = 0; i < al; i++) {
            for (int j = 0; j < bl; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    aux[i+1][j+1] = aux[i][j];
                } else {
                    aux[i+1][j+1] = Math.min(aux[i][j], Math.min(aux[i][j + 1], aux[i+1][j])) + 1;
                }
            }
        }
        
        return aux[al][bl];
    }
}
