public class Solution {
    static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        
        ArrayList<ArrayList<Integer>> keysOrder = new ArrayList<ArrayList<Integer>>();
        HashMap<Long, ArrayList<Integer>> map = new HashMap<Long, ArrayList<Integer>>();
        
        for (int i = 0; i < A.size(); i++) {
            Long key = getKey(A.get(i));
            if (map.containsKey(key)) {
                map.get(key).add(i+1);
            } else {
                ArrayList<Integer> c = new ArrayList<Integer>();
                c.add(i+1);
                map.put(key, c);
                keysOrder.add(c);
            }
        }
        
        return keysOrder;
    }
    
    public Long getKey(String word) {
        long key = 0;
        for (int i = 0; i < word.length(); i++) {
            key += primes[(((int)word.charAt(i)) - 97)];
        }
        
        return new Long(key);
    }
}
