public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        if (A.length() == 0) {
            return 0;
        }

        int endOfLastWord = -1;
        int startOfLastWord = -1;
        for (int i = A.length()-1; i >= 0; i--) {
            if (Character.isLetter(A.charAt(i))) {
                if (endOfLastWord == -1) {
                    endOfLastWord = i+1;
                }
            } else {
                if (endOfLastWord != -1) {
                    startOfLastWord = i+1;
                    break;
                }
            }

            if (i == 0 && startOfLastWord == -1) {
                startOfLastWord = 0;
            }
            if (i == 0 && endOfLastWord == -1) {
                endOfLastWord = 0;
            }
        }

        //System.out.println("start: " + startOfLastWord + " end: " + endOfLastWord);
        return A.substring(startOfLastWord, endOfLastWord).length();
    }
}
