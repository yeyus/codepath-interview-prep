public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> result = new ArrayList();
        PriorityQueue<Integer> queue = new PriorityQueue();
        
        queue.add(A);
        queue.add(B);
        queue.add(C);
        
        while(result.size() < D) {
            int x = queue.poll();
            if (!result.isEmpty() && result.get(result.size() - 1) == x) {
                continue;
            }
            result.add(x);
            queue.add(x * A);
            queue.add(x * B);
            queue.add(x * C);
        }
        
        return result;
    }
}
