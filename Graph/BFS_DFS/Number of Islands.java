// T.C: O(m * n) 
// S.C: O(m * n) 
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


// T.C: O(m * n)
// S.C: O(1)
class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    boolean isSafe(int r, int c, int m, int n){
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    void solve(int i, int j, char[][] grid){
        grid[i][j] = 'v';

        int m = grid.length;
        int n = grid[0].length;

        for(int[] dir : directions){
            int r = i + dir[0];
            int c = j + dir[1];

            if(isSafe(r, c, m, n) && grid[r][c] == '1'){
                solve(r, c, grid);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> que = new ArrayDeque<>();
    
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    solve(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
}