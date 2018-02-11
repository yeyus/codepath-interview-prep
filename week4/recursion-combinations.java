public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> results = new ArrayList();
        backtrack(results, new ArrayList(), A, B, 1);
        return results;
    }
    
    public void backtrack(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> temp, int upto, int k, int start) {
        if (temp.size() == k) {
            results.add(new ArrayList(temp));
        } else if (temp.size() > k) return;
        
        for (int i = start; i <= upto; i++) {
            temp.add(i);
            backtrack(results, temp, upto, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
