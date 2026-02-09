// T.C: O(n*m)
// S.C: O(n*m)
class Solution {
    int solve(String text1, String text2, int i, int j, int[][] t){
        if(i < 0 || j < 0){
            return 0;
        }  

        if(t[i][j] != -1) return t[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            return t[i][j] = 1 + solve(text1, text2, i-1, j-1, t);
        }

        return t[i][j] = Math.max(solve(text1, text2, i-1, j, t), solve(text1, text2, i, j-1, t));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] t = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(t[i], -1);
        }

        return solve(text1, text2, n-1, m-1, t);
    }
}

// T.C: O(n*m)
// S.C: O(n*m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2){
        int n = text1.length();
        int m = text2.length();

        int[][] t = new int[n+1][m+1];

        t[n][m] = 0;
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    t[i][j] = 1 + t[i+1][j+1];
                    continue;
                }

                t[i][j] = Math.max(t[i+1][j], t[i][j+1]);
            }
        }
        return t[0][0];
    }
}