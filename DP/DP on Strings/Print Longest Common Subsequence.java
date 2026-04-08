// T.C: O(m*n)
// S.C: O(m*n)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] t = new int[n+1][m+1];

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    t[i][j] = 1 + t[i+1][j+1];
                }
                else{
                    t[i][j] = Math.max(t[i+1][j], t[i][j+1]);
                }
            }
        }

        int i = 0, j = 0;
        StringBuilder lcs = new StringBuilder();
        while(i < n && j < m){
            if(text1.charAt(i) == text2.charAt(j)){
                lcs.append(text1.charAt(i));
                i++;
                j++;
            }
            else{
                if(t[i+1][j] > t[i][j+1]){
                    i++;
                }
                else{
                    j++;
                }
            }
        }
        System.out.println(lcs);

        return t[0][0];
    }
}