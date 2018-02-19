public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) {
            return 0;
        }
     
        //System.out.print(A);
        
        // calculate consecutive 1 in column
        Integer aux[][] = new Integer[A.size()][A.get(0).size()];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if (A.get(i).get(j) == 1) {
                    if (i == 0) {
                        aux[i][j] = 1;
                    } else if (aux[i-1][j] > 0) {
                        aux[i][j] = aux[i-1][j] + 1;
                    } else {
                        aux[i][j] = 1;
                    }
                } else {
                    aux[i][j] = 0;
                }
            }
        }
        
        // sort rows
        for (int i = 0; i < aux.length; i++) {
            Arrays.sort(aux[i], Collections.reverseOrder());
        }
        
        // get max area
        int current = 0;
        int max = 0;
        for (int i = 0; i < aux.length; i++) {
            for (int j = 0; j < aux[i].length; j++) {
                current  = (j+1) * aux[i][j];
                max = Math.max(max, current);
            }
        }
        
        //System.out.print(Arrays.deepToString(aux));
        
        return max;
    }
}
