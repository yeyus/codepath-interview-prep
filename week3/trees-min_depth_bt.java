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
    public int minDepth(TreeNode A) {
        return depth(A, 0);
    }
    
    public int depth(TreeNode A, int depth) {
        if (A == null) {
            return depth;
        }
        int maxl = depth(A.left, depth+1);
        int maxr = depth(A.right, depth+1);
        if (A.left != null && A.right != null) {
            return Math.min(maxl, maxr);
        } else if (A.left != null) {
            return maxl;
        } else {
            return maxr;
        }
    }
}
