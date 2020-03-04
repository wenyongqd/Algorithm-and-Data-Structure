/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {
            if (root.left != null && root.left.val == sum - root.val && root.left.left == null && root.left.right == null) {
                return true;
            }
            if (root.right != null && root.right.val == sum - root.val && root.right.left == null && root.right.right == null) {
                return true;
            }
            if (root.val == sum && root.left == null && root.right == null) {
                return true;
            }
        
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }

        return false;
    }
}