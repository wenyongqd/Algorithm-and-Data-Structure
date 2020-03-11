/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {

    private HashMap<Integer, Node> hashMap = new HashMap<>();    //记录已克隆的节点
    public Node cloneGraph(Node node) {
        if(null == node){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        hashMap.put(node.val, new Node(node.val));
        Node root = hashMap.get(node.val);
        while(!queue.isEmpty()){
            Node now = queue.poll();
            Node cloned = hashMap.get(now.val);
            for(Node neighbor : now.neighbors){
                if(!hashMap.containsKey(neighbor.val)){
                    queue.add(neighbor);
                    hashMap.put(neighbor.val, new Node(neighbor.val));
                }
                cloned.neighbors.add(hashMap.get(neighbor.val));
            }
        }
        return root;
    }
}