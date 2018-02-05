public class Solution {
    public int findMinXor(ArrayList<Integer> A) {
        int xor = Integer.MAX_VALUE;
        
        Collections.sort(A);
        for(int i=0;i<A.size()-1;i++) {
            int val = A.get(i) ^ A.get(i+1);
            xor = Math.min(xor, val);
        }
        
        return xor;
    }
}
