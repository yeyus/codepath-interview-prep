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
    public int maxDepth(TreeNode A) {
        return depth(A, 0);
    }
    
    public int depth(TreeNode A, int depth) {
        if (A == null) {
            return depth;
        }
        return Math.max(depth(A.left, depth+1), depth(A.right, depth+1));
    }
}
