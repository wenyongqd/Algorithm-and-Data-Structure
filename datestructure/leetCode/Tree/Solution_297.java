/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return helper(root, "");
    }
    public String helper(TreeNode root, String str) {
        if ( root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = helper(root.left, str);
            str = helper(root.right, str);
        }
        return str;   
    }
    public TreeNode deserialize(String data) {
        
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(data.split(",")));

        return dehelper(list);
        
    }
    
    public TreeNode dehelper(ArrayList<String> data) {
        
        if (data.get(0).equals("null")) {
            data.remove(0);
            return null;
        } 
        TreeNode root = new TreeNode(Integer.valueOf(data.get(0)));

            data.remove(0);
            root.left = dehelper(data);
            root.right = dehelper(data);
        return root; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));