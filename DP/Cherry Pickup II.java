// Approach: Memoization
// T.C: O(n*m*m)
// S.C: O(n*m*m)
class Solution {
    int n;
    int m;
    int[][][] t;
    int solve(int row, int col1, int col2, int[][] grid){
        if(col1 < 0 || col2 < 0 || col1 >= m || col2 >= m) return 0;

        if(row == n-1){
            if(col1 == col2) return t[row][col1][col2] =  grid[row][col1];
            else return t[row][col1][col2] = grid[row][col1] + grid[row][col2];
        }

        if(t[row][col1][col2] != -1) return t[row][col1][col2];
        
        int maxPick = 0;

        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int pick = 0;

                if(col1 == col2) {
                    pick = grid[row][col1];
                }
                else{
                    pick = grid[row][col2] + grid[row][col1];
                }   
                
                pick += solve(row+1, col1+i, col2+j, grid);
                maxPick = Math.max(pick, maxPick);
            }
        }
        return t[row][col1][col2] = maxPick;
    }
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        t = new int[n][m][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                Arrays.fill(t[i][j], -1);
            }
        }
        return solve(0, 0, m-1, grid);
    }
}