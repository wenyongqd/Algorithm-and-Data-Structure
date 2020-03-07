package leetCode.Tree;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Node> next = new ArrayList<Node>();
        List<Node> curNode = new ArrayList();

        curNode.add(root);

        while (!curNode.isEmpty()) {
            ArrayList temp = new ArrayList();
            for (Node curNodes : curNode) {
                if (curNodes != null) {
                    temp.add(curNodes.val);
                    next.addAll(curNodes.children);
                }
            }
            if (!temp.isEmpty()) {
                ans.add(temp);
            }
            curNode = new ArrayList<Node>(next);
            next.clear();
        }
        return ans;
    }
}