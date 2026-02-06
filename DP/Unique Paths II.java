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