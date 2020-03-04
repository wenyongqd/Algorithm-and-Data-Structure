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
    public int sumNumbers(TreeNode root) {     
        return helper(root,0);   
    }
    public int helper(TreeNode root, int val) {
        if (root != null) {
            val = val*10 +  root.val;
            if (root.left== null && root.right == null) return val;           
        } else {
            return 0;
        }
        return helper(root.left,val) + helper(root.right,val);
    } 
}