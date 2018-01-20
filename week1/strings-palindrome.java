public class Solution {
    public int isPalindrome(String A) {
        StringBuffer buff = new StringBuffer();
        for(int i = 0; i < A.length(); i++) {
            if (Character.isLetterOrDigit(A.charAt(i))) {
                buff.append(Character.toLowerCase(A.charAt(i)));
            }
        }

        for (int i = 0; i < buff.length(); i++) {
            if (buff.charAt(i) != buff.charAt(buff.length()-i-1)) {
                return 0;
            }
        }

        return 1;
    }
}
