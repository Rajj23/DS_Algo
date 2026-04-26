// Approach: top-down
// T.C: O(n^2)
// S.C: OO(n^2)
class Solution {
    int[][] t;
    int solve(int i, int j, String s){
        if(i >= j) return 0;

        if(t[i][j] != -1) return t[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return t[i][j] = solve(i+1, j-1, s);
        }
        else{
            return t[i][j] = 1 + Math.min(
                solve(i+1, j, s),
                solve(i, j-1, s)
            );
        }

    }
    public int minInsertions(String s) {
        int n = s.length();
        t = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(t[i], -1);
        }

        return solve(0, n-1, s);
    }
}


// Approach: bottom-up
// T.C: O(n^2)
// S.C: OO(n^2)
class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int[][] t = new int[n+1][n+1];

        for(int i = n-2; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i == 1){
                        t[i][j] = 0;
                    }
                    else
                        t[i][j] = t[i+1][j-1];
                }
                else{
                    t[i][j] = 1 + Math.min(t[i+1][j], t[i][j-1]);
                }
            }
        }
        return t[0][n-1];
    }
}