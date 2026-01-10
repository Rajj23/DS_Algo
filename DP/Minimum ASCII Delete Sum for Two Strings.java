//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    int m,n;
    int[][] t;
    private int solve(String s1, String s2, int i, int j){
        if(i >= m && j >= n){
            return 0;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }

        if(i >= m){
            return t[i][j] = (int)s2.charAt(j) + solve(s1, s2, i, j+1);
        }
        else if(j >= n){
            return t[i][j] = (int)s1.charAt(i) + solve(s1, s2, i+1, j);
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return t[i][j] = solve(s1, s2, i+1, j+1);
        }

        int delete_s1_i = (int)s1.charAt(i) + solve(s1, s2, i+1, j);
        int delete_s2_j = (int)s2.charAt(j) + solve(s1, s2, i, j+1);

        return t[i][j] = Math.min(delete_s1_i, delete_s2_j);
    }

    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();

        t = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                t[i][j] = -1;
            }
        }

        return solve(s1,s2,0,0);
    }
}