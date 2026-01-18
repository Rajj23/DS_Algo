// T.C: O(m^2 * n^2)
// S.C: O(1)
class Solution {
    boolean solve(int i, int j, int len, int[][] grid){
        int target = 0;

        for(int y = 0; y < len; y++){
            target += grid[i][j+y];
        }

        for(int x = 0; x < len; x++){
            int sum = 0;
            for(int y = 0; y < len; y++){
                sum += grid[i+x][j+y];
            }

            if(sum != target) return false;
        }

        for(int y = 0; y < len; y++){
            int sum = 0;
            for(int x = 0; x < len; x++){
                sum += grid[i+x][j+y];
            }

            if(sum != target) return false;
        }

        int d1 = 0;
        for(int x = 0; x < len; x++){
            d1 += grid[i+x][j+x];
        }
        if(d1 != target) return false;

        int d2 = 0;
        for(int x = 0; x < len; x++){
            d2 += grid[i+x][j+len-1-x];
        }
        if(d2 != target) return false;

        return true;
    }
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int len = 0; len+i <= m && len+j <= n; len++){
                    if(solve(i, j, len, grid)){
                        ans = Math.max(ans, len);
                    }
                }
            }
        }

        return ans;
    }
}



//T.C : O(rows * cols * min(rows, cols)^2) --> check my video for its explanation
//S.C : O(rows * cols)
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] rowCumSum = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            rowCumSum[i][0] = grid[i][0];
            for(int j = 1; j < cols; j++){
                rowCumSum[i][j] = rowCumSum[i][j-1] + grid[i][j];
            }
        }


        int[][] colCumSum = new int[rows][cols];
        for(int j = 0; j < cols; j++){
            colCumSum[0][j] = grid[0][j];
            for(int i = 1; i < rows; i++){
                colCumSum[i][j] = colCumSum[i-1][j] + grid[i][j];
            }
        }


        for(int side = Math.min(rows, cols); side >= 1; side--){

            for(int i = 0; i + side - 1 < rows; i++){
                for(int j = 0; j + side - 1 < cols; j++){

                    int targetSum = rowCumSum[i][j+side-1] - (j > 0 ? rowCumSum[i][j-1] : 0);

                    boolean allSame = true;

                    for(int r = i+1; r < i + side; r++){
                        int rowSum = rowCumSum[r][j+side-1] - (j > 0 ? rowCumSum[r][j-1] : 0);

                        if(rowSum != targetSum){
                            allSame = false;
                            break;
                        }
                    }

                    if(!allSame){
                        continue;
                    }

                    for(int c = j; c < j + side; c++){
                        int colSum = colCumSum[i + side -1][c] - (i > 0 ? colCumSum[i-1][c] : 0);

                        if(colSum != targetSum){
                            allSame = false;
                            break;
                        }
                    }

                    if(!allSame){
                        continue;
                    }

                    int diag = 0;
                    int antiDiag = 0;
                    for(int k = 0; k < side; k++){
                        diag += grid[i+k][j+k];
                        antiDiag += grid[i+k][j + side -1 -k];
                    }

                    if(diag == targetSum && antiDiag == targetSum){
                        return side;
                    }

                }
            }
        }
        return 1;
    }
}