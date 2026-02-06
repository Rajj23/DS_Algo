// Approach: Recursion
// T.C: O(3^n)
// S.C: O(1)
class Solution {
    int n;
    int m;
    int solve(int col, int row, int[][] matrix){
        if(row < 0 || row >= m) return Integer.MAX_VALUE/2;

        if(col == n-1){
            return matrix[col][row];
        }

        int bottom  = matrix[col][row] + solve(col+1, row, matrix); 

        int leftDiag = matrix[col][row] + solve(col+1, row-1, matrix);
    
        int rightDiag = matrix[col][row] + solve(col+1, row+1, matrix);


        return Math.min(bottom, Math.min(leftDiag, rightDiag));
    }

    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;

        int ans = Integer.MAX_VALUE;

        for(int j = 0; j < m ; j++){
            ans = Math.min(ans, solve(0, j, matrix));
        }

        return ans;
    }
}



// Approach: Tabulization
// T.C: O(n*m)
// S.C: O(n*m)
class Solution {
    public int minFallingPathSum(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] t = new int[n][m];

        for(int j = 0; j < m; j++){
            t[n-1][j] = matrix[n-1][j]; 
        }

        for(int col = n-2; col >= 0; col--){
            for(int row = m-1; row >= 0; row--){
                
                int down = matrix[col][row] + t[col+1][row];
                int leftDiag = Integer.MAX_VALUE;
                if(row-1 >= 0)
                    leftDiag = matrix[col][row] + t[col+1][row-1];
                
                int rightDiag = Integer.MAX_VALUE;
                if(row + 1 < m)
                    rightDiag = matrix[col][row] + t[col+1][row+1];

                t[col][row] = Math.min(down, Math.min(leftDiag, rightDiag));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            ans = Math.min(ans, t[0][j]);
        }

        return ans;
    }
}