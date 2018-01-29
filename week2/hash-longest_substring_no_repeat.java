public class Solution {
    public int lengthOfLongestSubstring(String A) {
        HashSet<Character> set = new HashSet<>();

        int maxLength = 0;
        int start = 0;
        int end = 0;

        while(start < A.length() && end < A.length()) {
            if (!set.contains(A.charAt(end))) {
                set.add(A.charAt(end));
                end++;
            } else {
                set.remove(A.charAt(start));
                start++;
            }
            maxLength = Math.max(maxLength, end - start);
        }

        return maxLength;
    }
}
