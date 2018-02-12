/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    class Pair {
        public TreeNode node;
        public int level;
        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
        
        public String toString() {
            return "[(" + level + ") " + node.val + "]";
        }
    }
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        LinkedList<Pair> queue = new LinkedList();
        queue.add(new Pair(A, 0));
        
        while(!queue.isEmpty()) {
            Pair n = queue.poll();
            
            try {
                result.get(n.level).add(n.node.val);
            } catch (IndexOutOfBoundsException e) {
                result.add(n.level, new ArrayList());
                result.get(n.level).add(n.node.val);
            }
            
            if (n.node.left != null) {
                queue.add(new Pair(n.node.left, n.level + 1));
            }
            
            if (n.node.right != null) {
                queue.add(new Pair(n.node.right, n.level + 1));    
            }
        }
        
        return result;
    }
}
