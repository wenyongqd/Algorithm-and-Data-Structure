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
class Solution_508 {
    Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    int sum = 0;
    int max = 0;
    int temp;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = helper2(root,map,temp);      
        for (Integer value : map.values()) {
            if (value > max) {
                max = value;
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for(int key : map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        if (root == null) return new int[]{};
        if (map.get(list.get(list.size()-1)) == max) {
            return result;
        } else {
            return new int[]{result[list.size()-1]};
        }  
              
    }

    
    public int helper(TreeNode root) {
        if (root == null) return 0;
        sum = root.val + sum;
        helper(root.left);
        helper(root.right);

        return sum;
    }
    public Map<Integer,Integer> helper2(TreeNode root, Map<Integer, Integer> map, int temp) {
        if (root == null) return map;
        temp = 0;
        sum = 0;
        temp = helper(root);
        if (map.containsKey(temp)) {
            map.put(temp, map.get(temp) + 1);
        } else {
           map.put(temp, 0); 
        }
        
        helper2(root.left, map, temp);
        helper2(root.right, map,temp);
        
        return map;
    }
}