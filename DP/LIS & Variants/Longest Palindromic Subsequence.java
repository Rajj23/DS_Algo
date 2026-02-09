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