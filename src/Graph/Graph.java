package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

        private int number = 9;
        private boolean[] flag;
        private String[] vertexs = { "1", "2", "3", "4", "E", "F", "G", "H", "I" };
        private int[][] edges = {
//                { 0, 1, 0, 0, 0, 1, 1, 0, 0 },
//                { 1, 0, 1, 0, 0, 0, 1, 0, 1 },
//                { 0, 1, 0, 1, 0, 0, 0, 0, 1 },
//                { 0, 0, 1, 0, 1, 0, 1, 1, 1 },
//                { 0, 0, 0, 1, 0, 1, 0, 1, 0 },
//                { 1, 0, 0, 0, 1, 0, 1, 0, 0 },
//                { 0, 1, 0, 1, 0, 1, 0, 1, 0 },
//                { 0, 0, 0, 1, 1, 0, 1, 0, 0 },
//                { 0, 1, 1, 1, 0, 0, 0, 0, 0 }
                { 1, 1, 1, 1, 0 },
                { 1, 1, 0, 1, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0  }
        };

        void DFSTraverse() {
            flag = new boolean[number];
            for (int i = 0; i < number; i++) {
                if (flag[i] == false) {// 当前顶点没有被访问
                    DFS(i);
                }
            }
        }

        void DFS(int i) {
            flag[i] = true;// 第i个顶点被访问
            System.out.print(vertexs[i] + " ");
            for (int j = 0; j < number; j++) {
                if (flag[j] == false && edges[i][j] == 1) {
                    DFS(j);
                }
            }
        }

        void DFS_Map(){
            flag = new boolean[number];
            Stack<Integer> stack =new Stack<Integer>();
            for(int i=0;i<number;i++){
                if(flag[i]==false){
                    flag[i]=true;
                    System.out.print(vertexs[i]+" ");
                    stack.push(i);
                }
                while(!stack.isEmpty()){
                    int k = stack.pop();
                    for(int j=0;j<number;j++){
                        if(edges[k][j]==1&&flag[j]==false){
                            flag[j]=true;
                            System.out.print(vertexs[j]+" ");
                            stack.push(j);
                            break;
                        }
                    }

                }
            }
        }

        void BFS_Map(){
            flag = new boolean[number];
            Queue<Integer> queue = new LinkedList<Integer>();
            for(int i=0;i<number;i++){
                if(flag[i]==false){
                    flag[i]=true;
                    System.out.print(vertexs[i]+" ");
                    queue.add(i);
                    while(!queue.isEmpty()){
                        int k=queue.poll();
                        for(int j=0;j<number;j++){
                            if(edges[k][j]==1&&flag[j]==false){
                                flag[j] = true;
                                System.out.print(vertexs[j]+" ");
                                queue.add(j);
                            }
                        }
                    }
                }
            }
        }
}
