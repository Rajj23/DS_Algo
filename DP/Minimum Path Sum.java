// Approach: Recursion
// T.C: O(2^n)
// S.C: O(1)
class Solution {
    int solve(int i, int j, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        if(i >= n && j >= m){
            return Integer.MAX_VALUE;
        }

        if(i == n- 1 && j == m-1){
            return grid[i][j];
        }

        int down = Integer.MAX_VALUE;
        if(i+1 < n){
            down = grid[i][j] + solve(i+1, j, grid);
        }

        int left = Integer.MAX_VALUE;

        if(j+1 < m)
            left = grid[i][j] + solve(i , j+1, grid);

        return Math.min(down, left);
    }

    public int minPathSum(int[][] grid) {
        return solve(0, 0, grid);
    }
}


// Appraoch: Tabulization
// T.C: O(n*m)
// S.C: O(n*m)
class Solution {
    public int minPathSum(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] t = new int[n+1][m+1];

        t[n-1][m-1] = grid[n-1][m-1];

        for(int col = n-2; col >= 0; col--){
            t[col][m-1] = t[col+1][m-1] + grid[col][m-1];
        }

        for(int row = m-2; row >= 0; row--){
            t[n-1][row] = t[n-1][row+1] + grid[n-1][row];
        }

        for(int col = n-2; col >= 0; col--){
            for(int row = m-2; row >= 0; row--){

                int left = grid[col][row] + t[col][row+1];

                int down = grid[col][row] + t[col+1][row];

                t[col][row] = Math.min(left, down);
            }
        }

        return t[0][0];
    }
}