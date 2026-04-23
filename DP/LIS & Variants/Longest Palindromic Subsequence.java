// Approach 1 : (rec + memo)
// T.C: O(n*n)
// S.C: O(n*n)
class Solution {
    int[][] t;
    int solve(int i, int j, String s1, String s2){
        if(i >= s1.length() || j >= s2.length()) return 0;

        if(t[i][j] != -1) return t[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return t[i][j] = 1 + solve(i+1, j+1, s1, s2);
        }
        else{
            return t[i][j] = Math.max(
                solve(i+1, j, s1, s2),
                Math.max(solve(i, j+1, s1, s2), solve(i+1, j+1, s1, s2))
            );
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        t = new int[n][n];
        String s2 = new StringBuilder(s).reverse().toString();

        for(int i = 0; i < n; i++){
            Arrays.fill(t[i], -1);
        }

        return solve(0, 0, s, s2);
    }
}


// Approach 2: O(n*n)
// T.C: O(n*n)
// S.C: O(n*n)
class Solution {
    public int longestPalindromeSubseq(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();

        int n = s1.length();
        int[][] t = new int[n+1][n+1];
        t[n][n] = 0;

        for(int i = n-1; i >= 0; i--){new StringBuilder(s).reverse().toString();
            for(int j = n-1; j>= 0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    t[i][j] = 1 + t[i+1][j+1];
                    continue;
                }

                t[i][j] = Math.max(t[i][j+1], t[i+1][j]);
            }
        }

        return t[0][0];
    }
}