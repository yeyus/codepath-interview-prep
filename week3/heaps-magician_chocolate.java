public class Solution {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Long> queue = new PriorityQueue<>(10, Collections.reverseOrder());

        for(Integer i: B) {
            queue.add(new Long(i));
        }

        long candyeaten = 0;
        for(int i = 0; i < A; i++) {
            long candy = queue.poll();
            queue.add(candy/2);
            candyeaten = candyeaten + candy;
            //System.out.printf("[%s => %d]", queue, candyeaten);
        }

        return (int)(candyeaten % 1000000007);
    }
}
