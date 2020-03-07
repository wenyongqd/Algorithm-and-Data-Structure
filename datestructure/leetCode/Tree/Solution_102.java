package leetCode.Tree;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

// i: 表示第几个
// j: 表示第几层
class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList ans = new ArrayList();
        ArrayList next = new ArrayList();
        ArrayList curNode = new ArrayList();
        curNode.add(root);

        while (!curNode.isEmpty()) {
            ArrayList temp = new ArrayList();
            for (Object curNodes : curNode) {
                if (curNodes != null) {
                    temp.add(((TreeNode) curNodes).val);
                    next.add(((TreeNode) curNodes).left);
                    next.add(((TreeNode) curNodes).right);
                }
            }
            if (!temp.isEmpty()) {
                ans.add(temp);
            }
            curNode = (ArrayList) next.clone();
            next.clear();
        }
        return ans;
    }
}