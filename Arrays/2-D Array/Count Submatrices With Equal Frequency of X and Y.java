//Approach (Using Same Cumulative Sum of Submatrices Concept we used in Leetcode 3070)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        int[][] xMatrix = new int[m][n];
        int[][] yMatrix = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 'X'){
                    xMatrix[i][j] = 1;
                }
                else if(grid[i][j] == 'Y'){
                    yMatrix[i][j] = 1;
                }
                

                if(i-1 >= 0){
                    xMatrix[i][j] += xMatrix[i-1][j];
                    yMatrix[i][j] += yMatrix[i-1][j];
                }
                if(j-1 >= 0){
                    xMatrix[i][j] += xMatrix[i][j-1];
                    yMatrix[i][j] += yMatrix[i][j-1];
                }
                if(i-1 >= 0 && j-1 >= 0){
                    xMatrix[i][j] -= xMatrix[i-1][j-1];
                    yMatrix[i][j] -= yMatrix[i-1][j-1];
                }

                if(xMatrix[i][j] == yMatrix[i][j] && 
                        xMatrix[i][j] > 0) 
                                count++;
            }
        }

        return count;
    }
}