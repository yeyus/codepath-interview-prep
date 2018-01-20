public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        ArrayList<String> sorted = new ArrayList<String>();

        for (int i = 0; i < A.size(); i++) {
            sorted.add(String.valueOf(A.get(i)));
        }

        Collections.sort(sorted, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    String ab = a + b;
                    String ba = b + a;

                    return ab.compareTo(ba) < 0 ? 1 : -1;
                }
            });

        String result = String.join("", sorted);
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result;
    }
}
