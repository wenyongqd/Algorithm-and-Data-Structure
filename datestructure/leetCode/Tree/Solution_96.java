class Solution_96 {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        int res = 0;
        
        G[0] = 1;
        G[1] = 1;
        
        for (int j = 2; j <=n; j++) {
            
            for(int i = 1; i <= j; i++ ) {
                G[j] = G[i-1]*G[j-i]  + G[j];                
            }
        }
        return G[n];
    }
}