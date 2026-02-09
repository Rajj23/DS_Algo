// T.C: O(n*m)
// S.C: O(n*m)
class Solution {
    public static int minSuperSeq(String str1, String str2) {
        // code here
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        dp[n][m] = 0;

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        int lcs = dp[0][0];
        return n+m - lcs;
    }
}