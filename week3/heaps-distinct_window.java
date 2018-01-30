public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < B; i++) {
            int val = map.getOrDefault(A.get(i), 0);
            map.put(A.get(i), val + 1);
        }
        result.add(map.keySet().size());

        for (int start = 1; start + B <= A.size(); start++) {
            int prev = A.get(start-1);
            int prevCount = map.getOrDefault(prev, 1);
            if (prevCount == 1) {
                map.remove(prev);
            } else {
                map.put(prev, prevCount - 1);
            }

            int next = A.get(start + B - 1);
            int nextCount = map.getOrDefault(next, 0);
            map.put(next, nextCount + 1);

            result.add(map.keySet().size());
        }
        return result;
    }
}
