//Approach - Suffix and Prefix Products
//T.C : O(n*m)
//S.C : O(n*m) , for the result to be returned
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 12345;
        int[][] suffix = new int[m][n];

        suffix[m-1][n-1] = 1;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == m-1 && j == n-1) continue;

                long suffixNext, gridNext;
                if(j+1 <= n-1){
                    suffixNext = suffix[i][j+1];
                    gridNext = grid[i][j+1];
                }
                else{
                    suffixNext = suffix[i+1][0];
                    gridNext = grid[i+1][0];
                }
                suffix[i][j] = (int)((suffixNext * (gridNext % MOD)) % MOD);
            }
        }

        long prod = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               
                suffix[i][j] = (int) (suffix[i][j] * prod) % MOD;
                prod = (prod * grid[i][j] % MOD) % MOD;

            }
        }

        return suffix;
    }
}


//Approach - Suffix and Prefix Products
//T.C : O(n*m)
//S.C : O(n*m) , for the result to be returned
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 12345;
        int[][] suffix = new int[m][n];

        long prod = 1;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                suffix[i][j] = (int) prod;
                prod = (prod * grid[i][j]) % MOD;
            }
        }

        long prefix = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               suffix[i][j] = (int) (prefix * suffix[i][j]) % MOD;
               prefix = (prefix * grid[i][j]) % MOD;
            }
        }

        return suffix;
    }
}