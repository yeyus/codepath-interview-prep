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
    public int hasPathSum(TreeNode A, int B) {
        HashMap<TreeNode, Integer> remainder = new HashMap<>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(A);
        remainder.put(A, B - A.val);
        
        while(!s.isEmpty()) {
            TreeNode n = s.pop();
            int r = remainder.get(n);
            
            if (r == 0 && n.left == null && n.right == null) {
                return 1;
            }
            
            if (n.left != null) {
                s.push(n.left);
                remainder.put(n.left, r - n.left.val);
            }
            
            if (n.right != null) {
                s.push(n.right);
                remainder.put(n.right, r - n.right.val);
            }
        }
        
        return 0;
    }
}
