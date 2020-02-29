/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
             
        Queue<TreeNode> queue = new LinkedList<>();        
        queue.offer(p);
        queue.offer(q);
        
        while(!queue.isEmpty()) {
            
            p = queue.poll();
            q = queue.poll();
                           
            if(p == null && q != null) return false;
            if(q == null && p != null) return false;               
            if(p == null && q == null) continue;
            if (p == null || q == null) return false;
            if(q.val != p.val) return false;
                
            queue.offer(p.left);
            queue.offer(q.left);
            queue.offer(p.right);
            queue.offer(q.right);

        }
        return true;
    }
        
}