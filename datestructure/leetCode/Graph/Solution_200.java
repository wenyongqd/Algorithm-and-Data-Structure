class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int res = 0;
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfsHelper(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfsHelper(char[][] grid, int x, int y) {
        if ( x < 0 || y > grid[0].length -1 || x > grid.length - 1 || y < 0 || grid[x][y] == '0') return;
        grid[x][y] = '0';
        dfsHelper(grid, x, y - 1);
        dfsHelper(grid, x, y + 1);
        dfsHelper(grid, x - 1, y);
        dfsHelper(grid, x + 1, y);
    }
}