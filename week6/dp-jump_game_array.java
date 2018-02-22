public class Solution {
    public int canJump(ArrayList<Integer> A) {
        if (A.size() < 2) return 1;
        
        for (int i = A.size()-2; i >= 0; i--) {
            if (A.get(i) == 0) {
                int jumps = 1;
                while (jumps > A.get(i)) {
                    jumps++;
                    i--;
                    if (i < 0) return 0;
                }
            }
        }
        
        return 1;
    }
}
