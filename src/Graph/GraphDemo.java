package Graph;

public class GraphDemo {
    public static void main(String[] args) {
        Graph graph = new Graph();
        System.out.println("DFS递归:");
        graph.DFSTraverse();
        System.out.println();
        System.out.println("DFS非递归:");
        graph.DFS_Map();
        System.out.println();
        System.out.println("BFS非递归:");
        graph.BFS_Map();
    }
}
