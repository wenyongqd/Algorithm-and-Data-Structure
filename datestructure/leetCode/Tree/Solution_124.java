package leetCode.Tree;

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
    int res = Integer.MIN_VALUE +1;
    public int maxPathSum(TreeNode root) {
        
        helper(root);
        return res;
        
    }
    
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
 
    }
}