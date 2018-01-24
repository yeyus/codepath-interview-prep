public class Solution {
    public int colorful(int A) {
        String str = Integer.toString(A);
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i = 1; i <= str.length(); i++) {
            for (int j = i; j <= str.length(); j++) {
                //System.out.print(str.substring(j-i,j) + "-");
                int mult = getMult(str.substring(j-i,j));
                //System.out.print("{" + mult + "}");
                if (set.contains(mult)) {
                    return 0;
                } else {
                    set.add(mult);
                }
            }
        }
        
        return 1;
    }
    
    public int getMult(String num) {
        int mult = 1;
        for (int i = 0; i < num.length(); i++) {
            mult *= Character.getNumericValue(num.charAt(i));
        }
        
        return mult;
    }
}
