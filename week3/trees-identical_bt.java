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
    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        } else if (A != null && B != null) {
            if (A.val == B.val) {
                return Math.min(1, Math.min(isSameTree(A.left, B.left), isSameTree(A.right, B.right)));   
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
