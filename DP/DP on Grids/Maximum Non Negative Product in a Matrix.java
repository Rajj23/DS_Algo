//Approach - 1 (Recursion + Memoization)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {

    int MOD = (int) 1e9+7;

    Pair<Long, Long>[][] t;
    Pair<Long, Long> solve(int row, int col, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(row >= m || col >= n) {
            return new Pair<>((long) Integer.MAX_VALUE, (long)Integer.MIN_VALUE);
        }

        if(row == m-1 && col == n-1){
            return new Pair<>((long) grid[row][col], (long)grid[row][col]);
        }

        if(t[row][col] != null){
            return t[row][col];
        }

        Pair<Long, Long> down = solve(row+1, col, grid);

        Pair<Long, Long> right = solve(row, col+1, grid);


        long pathMax = Math.max(down.getValue(), right.getValue());
        long pathMin = Math.min(down.getKey(), right.getKey());

        long newMin, newMax;

        if(grid[row][col] < 0){
            newMax = pathMin * grid[row][col];
            newMin = pathMax * grid[row][col];
        }
        else{
            newMax = pathMax * grid[row][col];
            newMin = pathMin * grid[row][col];
        }

        t[row][col] = new Pair<>(newMin, newMax);
        return t[row][col];
    }
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        t = new Pair[m][n];

        Pair<Long, Long> result = solve(0, 0, grid);
        long ans = result.getValue();
        return ans < 0 ? -1 : (int) (ans % MOD);
    }
}


//Approach - 2 (Bottom Up)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    public int maxProductPath(int[][] grid) {
        int MOD = (int) 1e9+7;
        int m = grid.length, n = grid[0].length;
        Pair<Long, Long>[][] t = new Pair[m][n];

        t[0][0] = new Pair<>((long) grid[0][0], (long) grid[0][0]);

        for(int j = 1; j < n; j++){
            t[0][j] = new Pair<>(t[0][j-1].getKey() * grid[0][j],
                t[0][j-1].getValue()*grid[0][j]);
        }

        for(int i = 1; i < m; i++){
            t[i][0] = new Pair<>(t[i-1][0].getKey() * grid[i][0],
                t[i-1][0].getValue() * grid[i][0]);
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                long upMax = t[i - 1][j].getKey();
                long upMin = t[i - 1][j].getValue();

                long leftMax = t[i][j - 1].getKey();
                long leftMin = t[i][j - 1].getValue();

                t[i][j] = new Pair<>(
                    Math.max(Math.max(upMax * grid[i][j], upMin * grid[i][j]), Math.max(leftMax * grid[i][j], leftMin * grid[i][j])),
                    Math.min(Math.min(upMax * grid[i][j], upMin * grid[i][j]), Math.min(leftMax * grid[i][j], leftMin * grid[i][j]))
                );
            }
        }
        long maxProd = t[m-1][n-1].getKey();

        return maxProd < 0 ? -1 : (int) (maxProd % MOD);
    }
}