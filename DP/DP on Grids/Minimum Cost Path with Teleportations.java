//Approach-1 (Recursion + Memoization)
//T.C : O(m^2 * n^2 * k)
//S.C : O(m*n*k)
class Solution {
    int m;
    int n;
    int[][][] t;

    int solve(int i, int j, int tPort, int k, int[][] grid){
        if(i == m-1 && j == n-1){
            return 0;
        }

        if(t[i][j][tPort] != -1){
            return t[i][j][tPort];
        }

        int result = (int) 1e9;
        int curVal = grid[i][j];

        if(j+1 < n){
            int next = solve(i, j+1, tPort, k, grid);
            result = Math.min(result, grid[i][j+1] + next);
        }

        if(i+1 < m){
            int next = solve(i+1, j, tPort, k, grid);
            result = Math.min(result, grid[i+1][j] + next);
        }

        if(tPort < k){
            for(int x = 0; x < m; x++){
                for(int y = 0; y < n; y++){
                    if((x != i || y != j) && grid[x][y] <= curVal){
                        result = Math.min(result, 
                        solve(x, y, tPort+1, k, grid));
                    }
                }
            }
        }
        return t[i][j][tPort] = result;
    }

    public int minCost(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        t = new int[m][n][k+1];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(t[i][j], -1);
            }
        }

        return solve(0,0,0,k,grid);
    }
}



// T.C : O(m^2 * n^2 * k)
// S.C : O(m*n*k)
class Solution {
    public int minCost(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;

        int[][][] t = new int[m+1][n+1][k+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                for(int tp = 0; tp <= k; tp++){
                    t[i][j][tp] = (int) 1e9;
                }
            }
        }

        for(int tPort = 0; tPort <= k; tPort++){
            t[m-1][n-1][tPort] = 0;
        }

        for(int tPort = k; tPort >= 0; tPort--){
            for(int i = m-1; i >= 0; i--){
                for(int j = n-1; j >= 0; j--){

                    if(i == m-1 && j == n-1)
                        continue;

                    int result = (int)1e9;

                    if(j + 1 < n){
                        result = Math.min(result,
                            grid[i][j+1] + t[i][j+1][tPort]);
                    }   

                    if(i + 1 < m){
                        result = Math.min(result, 
                            grid[i+1][j] + t[i+1][j][tPort]);
                    }

                    if(tPort < k){
                        for(int x = 0; x < m; x++){
                            for(int y = 0; y < n; y++){
                                if((x != i || y != j) && grid[x][y] <= grid[i][j]){
                                    result = Math.min(result, t[x][y][tPort + 1]);
                                }
                            }
                        }
                    }

                    t[i][j][tPort] = result;
                }
            }
        }

        return t[0][0][0];
    }
}



// T.C : O(m*n*k)
// S.C : O(m*n*k)
class Solution {
    public int minCost(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        int maxVal = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = Integer.MAX_VALUE;
                maxVal = Math.max(grid[i][j], maxVal);
            }
        }
        dp[m-1][n-1] = 0;

        int[] teleportCost = new int[maxVal+1];
        Arrays.fill(teleportCost, Integer.MAX_VALUE);

        for(int t = 0; t <= k; t++){
            for(int i = m-1; i >= 0; i--){
                for(int j = n-1; j >= 0; j--){

                    if (i + 1 < m && dp[i + 1][j] != Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i][j], 
                            grid[i+1][j] + dp[i+1][j]);
                    }

                    if (j + 1 < n && dp[i][j + 1] != Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i][j],
                            grid[i][j+1] + dp[i][j+1]);
                    }

                    if(t > 0){
                        dp[i][j] = Math.min(dp[i][j], 
                            teleportCost[grid[i][j]]);
                    }
                }
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    teleportCost[grid[i][j]] = Math.min(teleportCost[grid[i][j]], dp[i][j]);
                }
            }

            for(int i = 1; i < teleportCost.length; i++){
                teleportCost[i] = Math.min(teleportCost[i], teleportCost[i-1]);
            }
        }

        return dp[0][0];
    }
}