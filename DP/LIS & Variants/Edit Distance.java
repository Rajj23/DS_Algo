// Approach: top-down
// T.C: O(m*n)
// S.C: O(m*n)
class Solution {
    int[][] t;
    int solve(int i, int j, String word1, String word2){
        if(i >= word1.length()){
            return word2.length() - j;
        }
        if(j >= word2.length()){
            return word1.length() - i;
        }

        if(t[i][j] != -1) return t[i][j];

        int cnt = 0;
        if(word1.charAt(i) == word2.charAt(j)){
            cnt = solve(i+1, j+1, word1, word2);
        }
        else{
            cnt = 1 + Math.min(Math.min(
                solve(i+1, j+1, word1, word2), 
                solve(i, j+1, word1, word2)), 
                solve(i+1, j, word1, word2));
        }

        return t[i][j] = cnt;
    }
    public int minDistance(String word1, String word2) {
        t = new int[501][501];
        for(int i = 0; i < 501; i++){
            Arrays.fill(t[i], -1);
        }
        return solve(0, 0, word1, word2);
    }
}


// Approach: bottom-up
// T.C: O(m*n)
// S.C: O(m*n)
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            dp[i][m] = n - i;
        }
        for(int j = 0; j <= m; j++){
            dp[n][j] = m - j;
        }

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
                }
            }
        }

        return dp[0][0];
    }
}