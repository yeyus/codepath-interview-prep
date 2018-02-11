public class Solution {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList();
        backtrack(result, new ArrayList(), a, 0);
        return result;
    }
	
    public void backtrack(ArrayList<ArrayList<String>> result, ArrayList<String> temp, String a, int start) {
        if (start == a.length()) {
            result.add(new ArrayList(temp));
            return;
        }
	    
        for (int i = start; i < a.length(); i++) {
            if (isPalindrome(a, start, i)) {
                temp.add(a.substring(start, i + 1));
                backtrack(result, temp, a, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
	
    public boolean isPalindrome(String a, int start, int end) {
        while(start < end) {
            if (a.charAt(start++) != a.charAt(end--)) {
                return false;
            }
        }
	    
        return true;
    }
}
