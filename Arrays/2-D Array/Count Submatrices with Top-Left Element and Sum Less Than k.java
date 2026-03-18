//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int[][] matrix = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
            
                matrix[i][j] = grid[i][j];
                if(i > 0){
                    matrix[i][j] += matrix[i-1][j];
                }
                if(j > 0){
                    matrix[i][j] += matrix[i][j-1];
                }
                if(i > 0 && j > 0){
                    matrix[i][j] -= matrix[i-1][j-1];
                }

                if(matrix[i][j] <= k) count++;
            }
        }

        return count;
    }
}