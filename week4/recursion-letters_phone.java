public class Solution {
    public ArrayList<String> letterCombinations(String A) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ans = new ArrayList<String>();
        
        if(A.isEmpty()) {
            return ans;
        }
        
        ans.add("");
        for(int i =0; i<A.length();i++){
            int x = Character.getNumericValue(A.charAt(i));
            while(ans.get(0).length()==i){
                String t = ans.remove(0);
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
