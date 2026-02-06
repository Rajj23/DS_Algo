// Approach: Recursion
// T.C: O(2^n*m)
// S.C: O(1)
class Solution {
    int[][] t;
    int solve(int row, int col, int m, int n){
        if(row >= m || col >= n) return t[row][col] = 0;
        if(row == m-1 && col == n-1) return t[row][col] = 1;

        if(t[row][col] != -1){
            return t[row][col];
        }

        int down = 0;
        if(row+1 < m){
            down = solve(row+1, col, m, n);
        }

        int right = 0;
        if(col+1 < n){
            right = solve(row, col+1, m, n);
        }

        return t[row][col] = down + right;
    }
    public int uniquePaths(int m, int n) {
        t = new int[m+1][n+1];

        for(int i = 0; i < m; i++){
            Arrays.fill(t[i], -1);
        }
        return solve(0,0,m,n);
    }
}


// Approach: Tabulization
// T.C: O(n*m)
// S.C: O(n*m)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t = new int[m][n];

        t[m-1][n-1] = 1;

        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {

                if (row == m-1 && col == n-1) continue;

                int down = 0;
                if (row + 1 < m) {
                    down = t[row+1][col];
                }

                int right = 0;
                if (col + 1 < n) {
                    right = t[row][col+1];
                }

                t[row][col] = down + right;
            }
        }
        return t[0][0];
    }
}