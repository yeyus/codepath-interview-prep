public class Solution {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList();
        backtrack(result, a, 0);
        return result;
    }
	
    public int backtrack(ArrayList<Integer> result, int bitn, int number) {
        if (bitn == 0) {
            result.add(number);
            return number;
        }
	    
        int n = number;
        n = backtrack(result, bitn - 1, n);
        n ^= (1 << (bitn - 1));
        n = backtrack(result, bitn - 1, n);
	    
        return n;
    }
}
