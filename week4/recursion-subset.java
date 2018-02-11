public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> results = new ArrayList();
        Collections.sort(A);
        backtrack(results, new ArrayList(), A, 0);
        return results;
    }
    
    public void backtrack(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> temp, ArrayList<Integer> nums, int height) {
        results.add(new ArrayList(temp));
        for (int i = height; i < nums.size(); i++) {
            temp.add(nums.get(i));
            backtrack(results, temp, nums, i + 1);
            temp.remove(temp.size()-1);
        }
    }
}
