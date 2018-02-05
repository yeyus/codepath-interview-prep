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
    public int kthsmallest(TreeNode A, int B) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = A;
        int count = B;
        
        while(!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode n = stack.pop();
                count--;
                if (count == 0) {
                    return n.val;
                }
                current = n.right;
            }
        }
        
        return -1;
    }
}
