//Approach-1 - Brute Force (Binary Search on Answer) and also memoizing it - TLE
//T.C : O(O(log(maxHealth) * m * n * maxHealth), total states in map = m * n * maxHealth
//S.C : O(m * n * maxHealth)
class Solution {
    int m, n;
    Boolean[][][] t;
    boolean isValid(int i, int j, int[][] dungeon, int health){
        health += dungeon[i][j];
        if(health <= 0){
            return false;
        }

        if(t[i][j][health] != null) return t[i][j][health];

        if(i == m-1 && j == n-1){
            return true;
        }

        boolean down = false;
        if(i+1 < m){
            down = isValid(i+1, j, dungeon, health);
        }

        boolean right = false;
        if(j+1 < n){
            right = isValid(i, j+1, dungeon, health);
        }

        return t[i][j][health] = down || right;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int ans = -1;
        m = dungeon.length;
        n = dungeon[0].length;

        int l = 1, r = (int) 1e5;

        while(l <= r){
            int mid = l + (r-l)/2;
            t = new Boolean[m][n][100005];
            if(isValid(0, 0, dungeon, mid)){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }
}


//Approach-2 (Using Recursion and Memoization) - ACCEPTED
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    int m, n;

    int[][] t;
    int solve(int i, int j, int[][] dungeon){
        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        if(i == m-1 && j == n-1){
            if(dungeon[i][j] > 0){
                return 1;
            }
            return Math.abs(dungeon[i][j]) + 1;
        }

        if(t[i][j] != -1) return t[i][j];

        int right = solve(i, j+1, dungeon);
        int down = solve(i+1, j, dungeon);

        int result = Math.min(right, down) - dungeon[i][j];

        return t[i][j] = (result > 0) ? result : 1;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;

        t = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(t[i], -1);
        }

        return solve(0, 0, dungeon);
    }
}


//Approach-3 (Bottom Up) - ACCEPTED
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] t = new int[m][n];

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == m-1 && j == n-1){
                    t[i][j] = (dungeon[i][j] > 0) ? 1 : Math.abs(dungeon[i][j]) + 1;
                }
                else{
                    int down = (i+1 >= m) ? (int)1e9 : t[i+1][j];
                    int right = (j+1 >= n) ? (int) 1e9 : t[i][j+1];

                    int result = Math.min(down, right) - dungeon[i][j];
                    t[i][j] = (result > 0) ? result : 1;
                }
            }
        }
        return t[0][0];
    }
}