public class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int r = A.size();
        int c = A.get(0).size();
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j != 0) {
                    A.get(i).set(j, A.get(i).get(j) + A.get(i).get(j-1));
                } else if ( i != 0 && j == 0) {
                    A.get(i).set(j, A.get(i).get(j) + A.get(i - 1).get(j));
                } else if ( i == 0 && j == 0) {
                    // do nothing
                } else {
                    A.get(i).set(j, Math.min(A.get(i).get(j-1), A.get(i-1).get(j)) + A.get(i).get(j));
                }
            }
        }
        
        return A.get(r-1).get(c-1);
    }
}
