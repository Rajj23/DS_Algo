// Approach: Use recursion with memoization (top-down DP). For each state (row, col, k)
// we return the probability that the knight stays on the board after k moves,
// trying all 8 possible knight moves and averaging their probabilities. We cache
// results in a 3D DP array t[row][col][k] to avoid recomputation.
// T.C: O(n * n * k * 8) ≈ O(n^2 * k), since there are n^2 * k states and each
// state explores up to 8 moves.
// S.C: O(n * n * k) for the DP table plus O(k) recursion stack depth.
class Solution {
    int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] dc = {-1,  1, -2,  2, -2, 2, -1, 1};

    boolean isValid(int row, int col, int n){
        return row >= 0 && col >= 0 && row < n && col < n;
    }
    double[][][] t;
    double fun(int n, int row, int col, int k){
        if(!isValid(row, col, n)){
            return 0.0;
        }
        if(k == 0){
            return 1.0;
        }

        if(t[row][col][k] != -1.0){
            return t[row][col][k];
        }

        double currPro = 0.0;
        for(int i = 0; i < 8; i++){
            int r_new = dr[i] + row;
            int c_new = dc[i] + col;

            currPro += fun(n, r_new, c_new, k-1)/8.0;
        }
        t[row][col][k] = currPro;
        return currPro;
    }
    public double knightProbability(int n, int k, int row, int column) {
        t = new double[n+1][n][k+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(t[i][j], -1.0);
            }
        }
        return fun(n,row, column, k);
    }
}