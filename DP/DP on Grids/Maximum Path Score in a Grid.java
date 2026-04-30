//Approach-1 (Recursion + Memoization)
//T.C : O(m*n*k)
//S.C : O(m*n*k)
class Solution {
    int[][] directions = {{0, 1}, {1, 0}};
    int m, n;
    int[][][] t;
    int solve(int i, int j, int cost, int[][] grid, int k){
        cost += grid[i][j] != 0 ? 1 : 0;

        if(cost > k) return -1;

        if(i == m-1 && j == n-1){
            return grid[i][j];
        }

        if(t[i][j][cost] != Integer.MIN_VALUE) return t[i][j][cost];

        int max = -1;
        for(int[] dir : directions){
            int x = dir[0] + i;
            int y = dir[1] + j;

            if(x < 0 || x >= m || y < 0 || y >= n) continue;

            int next = solve(x, y, cost, grid, k);

            if(next != -1){
                max = Math.max(max, next + grid[i][j]);
            }
        }    
        return t[i][j][cost] = max;    
    }
    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        
        t = new int[m][n][k+1];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(t[i][j], Integer.MIN_VALUE);
            }
        }

        return solve(0, 0, 0, grid, k);       
    }
}

//Approach-2 (Recursion + Memoization)
//T.C : O(m*n*k)
//S.C : O(m*n*k)
class Solution {
    int[][] directions = {{0, 1}, {1, 0}};
    int m, n;
    int[][][] t;

    int solve(int i, int j, int cost, int[][] grid, int k){
        if(i == m-1 && j == n-1){
            if(cost <= k)
                return grid[m-1][n-1];

            return -1;
        }
        if(t[i][j][cost] != Integer.MIN_VALUE) return t[i][j][cost];

        int max = -1;
        for(int[] dir : directions){
            int x = dir[0] + i;
            int y = dir[1] + j;

            if(x < 0 || x >= m || y < 0 || y >= n) continue;

            int currCost = cost + (grid[x][y] == 0 ? 0 : 1);
            int res = -1;
            if(currCost <= k){
                res = solve(x, y, currCost, grid, k);

                if(res != -1)
                    max = Math.max(max, grid[i][j] + res);
            }
        }    
        return t[i][j][cost] = max;    
    }
    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        t = new int[m][n][k+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(t[i][j], Integer.MIN_VALUE);
            }
        }

        return solve(0, 0, 0, grid, k);       
    }
}


//Approach-3 (Bottom Up)
//T.C : O(m*n*k)
//S.C : O(m*n*k)
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] t = new int[m+1][n+1][k+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(t[i][j], -1);
            }
        }

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                for(int cost = k; cost >= 0; cost--){
                    int newCost = cost + (grid[i][j] > 0 ? 1 : 0);

                    if(newCost > k) continue;

                    if(i == m-1 && j == n-1){
                        t[i][j][cost] = grid[i][j];
                        continue;
                    }

                    int down = -1;
                    int right = -1;

                    if(i+1 < m)
                        down = t[i+1][j][newCost];

                    if(j+1 < n)
                        right = t[i][j+1][newCost];
                    
                    int bestNext = Math.max(down, right);

                    if(bestNext != -1)
                        t[i][j][cost] = grid[i][j] + bestNext;

                }
            }
        }
        return t[0][0][0];
    }
}