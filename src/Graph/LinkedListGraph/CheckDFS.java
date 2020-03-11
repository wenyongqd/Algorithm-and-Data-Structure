package Graph.LinkedListGraph;


class CheckDFS {
    public static String dfsTraversal(Graph g, int source) {

        String result = "";
        int num_of_vertices = g.vertices;

        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you push it into stack
        boolean[] visited = new boolean[num_of_vertices];

        //Create Stack(Implemented in previous lesson) for Depth First Traversal and Push source in it
        Stack<Integer> stack = new Stack<Integer>(num_of_vertices);

        stack.push(source);

        //Traverse while stack is not empty
        while (!stack.isEmpty()) {

            //Pop a vertex/node from stack and add it to the result
            int current_node = stack.pop();
            result += String.valueOf(current_node);

            //Visit the node
            visited[current_node] = true;

            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then push them in the stack
            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[current_node] !=null)
                temp = g.adjacencyList[current_node].headNode;

            while (temp != null) {

                if (!visited[temp.data]) {
                    stack.push(temp.data);
                }
                temp = temp.nextNode;
            }
        }//end of while
        return result;
    }
    public static void main(String args[]) {

        Graph g = new Graph(5);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,1);
        g.addEdge(2,4);
        g.addEdge(4,2);
        g.addEdge(4,3);
        g.addEdge(3,1);
        g.addEdge(3,4);


//        System.out.println(dfsTraversal(g, 0));
        System.out.println(dfsTraversal(g, 1));

//        System.out.println(g.adjacencyList[1].headNode.data);
//        System.out.println(g.adjacencyList[1].size);
//        System.out.println(g.adjacencyList[2].headNode.data);
//        System.out.println(g.adjacencyList[3].headNode.data);
//        System.out.println(g.adjacencyList[4].headNode.data);



    }

}