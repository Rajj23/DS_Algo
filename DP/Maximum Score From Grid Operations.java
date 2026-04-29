//T.C : O(n^3)
//S.C : O(n^2)
class Solution {
    int n;
    long[][][] t;
    long solve(int prevTaken, int prevHeight, int col, int[][] grid, long[][] colPrefSum){
        long result = 0;

        if(col == n) return 0;

        if(t[prevTaken][prevHeight][col] != -1) return t[prevTaken][prevHeight][col];

        for(int height = 0; height <= n; height++){
            long prevColScore = 0;
            long currColScore = 0;

            if(prevTaken == 0 && col > 0 && height > prevHeight){
                prevColScore = colPrefSum[height][col] - colPrefSum[prevHeight][col];
            }

            if(prevHeight > height){
                currColScore = colPrefSum[prevHeight][col+1] - colPrefSum[height][col+1];
            }

            long currColScoreTaken = currColScore + prevColScore + solve(1, height, col+1, grid, colPrefSum);
            long currColScoreNotTaken = prevColScore + solve(0, height, col+1, grid, colPrefSum);

            result = Math.max(result, Math.max(currColScoreNotTaken, currColScoreTaken));
        }
        return t[prevTaken][prevHeight][col] = result;
    }

    public long maximumScore(int[][] grid) {
        n = grid.length;

        long[][] colPrefSum = new long[n+1][n+1];
        t = new long[2][101][101];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 101; j++){
                Arrays.fill(t[i][j], -1);
            }
        }

        for(int col = 1; col <= n; col++){
            for(int row = 1; row <= n; row++){
                colPrefSum[row][col] = colPrefSum[row-1][col] + grid[row-1][col-1];
            }
        }

        return solve(0, 0, 0, grid, colPrefSum);
    }
}