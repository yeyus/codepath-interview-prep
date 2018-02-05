public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tempList, ArrayList<Integer> nums){
        if(tempList.size() == nums.size()){
            list.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.size(); i++){ 
                if(tempList.contains(nums.get(i))) continue; // element already exists, skip
                tempList.add(nums.get(i));
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    } 
}
