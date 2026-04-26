// T.C: O(V+E) + (n*m)
// S.C: O(n*m)
class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    boolean dfs(int row, int col, int pr, int pc, char ch, char[][] grid, boolean[][] visited){
        visited[row][col] = true;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < 4; i++){
            int r_ = row + dir[i][0];
            int c_ = col + dir[i][1];

            if(r_ < 0 || r_ >= n || c_ < 0 || c_ >= m) continue;
            if(grid[r_][c_] != ch) continue;
            if(r_ == pr && c_ == pc) continue;

            if(visited[r_][c_]) return true;

            if(dfs(r_, c_, row, col, ch, grid, visited)) return true;
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    if(dfs(i, j, -1, -1, grid[i][j], grid, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}