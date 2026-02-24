// T.C: O(V+E)
// S.C: O(2V)
class Solution {
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m;
    int n;

    boolean isValid(int r, int c){
        return r >= 0 && c >= 0 && r < m && c < n;
    }

    void dfs(int r, int c, char[][] grid, boolean[][] visited){
        if(visited[r][c] == true) return;

        visited[r][c] = true;

        for(int[] dir : direction){
            int r_ = r + dir[0];
            int c_ = c + dir[1];

            if(isValid(r_, c_) && grid[r_][c_] == '1'){
                dfs(r_, c_, grid, visited);
            }
        }
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int provision = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    provision++;
                    dfs(i, j, grid, visited);
                }
            }
        }

        return provision;
    }
}