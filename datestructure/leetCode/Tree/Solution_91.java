/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //中序遍历，使用stack
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while ( curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            res.add(curNode.val);
            curNode = curNode.right;
        }
        
        return res;
    }

}

//前序遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curNode = root;
        
        while (curNode != null || !stack.isEmpty()) {

            while ( curNode != null) {
                res.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            curNode = curNode.right;
        }
        
        return res;
    }
}