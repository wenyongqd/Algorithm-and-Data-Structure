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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        return helper(root,sum,temp,ans);        
    }
    public static List<List<Integer>> helper(TreeNode root, int sum, List temp, List ans) {
        if (root != null) {
            temp.add(root.val);

            if (root.val == sum && root.left == null && root.right == null) ans.add(new ArrayList<Integer>(temp));             
            ans = helper(root.left,sum - root.val,temp,ans);            
            ans = helper(root.right,sum - root.val,temp,ans);
            if (temp.size() >1) {
                temp.remove(temp.size()-1);
            }      
        }       
        return ans;  
    }
}