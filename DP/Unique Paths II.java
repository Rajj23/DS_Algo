// Approach: Top down
// T.C: O(n*m)
// S.C: O(n*m)
class Solution {
    int m,n;
    int[][] t;
    int solve(int i, int j, int[][] grid){
        if(i == m-1 && j == n-1){
            return grid[i][j] != 1 ? 1 : 0;
        }
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 1) return 0;

        if(t[i][j] != -1) return t[i][j];

        int down = solve(i+1, j, grid);
        int right = solve(i, j+1, grid);

        return t[i][j] = down + right;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        t = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(t[i], -1);
        }
        return solve(0, 0, grid);
    }
}


// Approach: Tabulization
// T.C: O(n*m)
// S.C: O(n*m)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] t = new int[n][m];

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){

                if(obstacleGrid[i][j] == 1){
                    t[i][j] = 0;
                    continue;
                }

                if(i == n-1 && j == m-1){
                    t[i][j] = 1;
                    continue;
                }

                int down = 0;
                if(i+1 < n){
                    down = t[i+1][j];
                }

                int right = 0;
                if(j+1 < m){
                    right = t[i][j+1];
                }

               
                t[i][j] = down+right;
                
            }
        }

        return t[0][0];
    }
}