//Approach (Recursion + Memoization)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {

    boolean isSafe(int row, int col, int m, int n){
        return row < m && col < n;
    }

    int[][][] t;
    int solve(int row, int col, int rem, int[][] coins){
        int m = coins.length;
        int n = coins[0].length;
        if(col == n-1 && row == m-1){
            int coin = coins[m-1][n-1];
            if(coin < 0 && rem > 0) return 0;
            return coin;
        }

        if(t[row][col][rem] != Integer.MIN_VALUE) return t[row][col][rem];

        int down = Integer.MIN_VALUE/2;
        int right = Integer.MIN_VALUE/2;
        if(coins[row][col] >= 0){
    
            if(isSafe(row+1, col, m, n)){
                down =  coins[row][col] + solve(row+1, col, rem, coins);
            }

            if(isSafe(row, col+1, m, n)){
                right =  coins[row][col] + solve(row, col+1, rem, coins);
            }
        }
        else{
            if(isSafe(row+1, col, m, n)){
                int remNow = rem;
                if(remNow > 0){
                    down = Math.max(down, solve(row+1, col, remNow-1, coins));
                }

                down = Math.max(down, coins[row][col] + solve(row+1, col, remNow, coins));
            }

            if(isSafe(row, col+1, m, n)){
                int remNow = rem;
                if(remNow > 0){
                    right = Math.max(right, solve(row, col+1, remNow-1, coins));
                }
                right = Math.max(right, coins[row][col]+solve(row, col+1, rem, coins));
            }
        }

        return t[row][col][rem] = Math.max(down, right);
    }
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        t = new int[m][n][3];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                Arrays.fill(t[i][j], Integer.MIN_VALUE);
        }

        return solve(0, 0, 2, coins);
    }
}