public class Solution {
    public int solve(String A) {
        StringBuffer buff = new StringBuffer(A);

        int pointer = A.length()-1;
        int counter = 0;
        while(!isPalindrome(buff.toString())) {
            buff.insert(counter, A.charAt(pointer--));
            counter++;
        }

        return counter;
    }

    public boolean isPalindrome(String A) {
        for(int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != A.charAt(A.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
