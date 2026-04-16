//Approach-1 (Recursion + Memoization)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    static int[][] t;
    static int solve(String s1, String s2, int m, int n){
        if(m == 0 || n == 0){
            return m+n;
        } 
        
        if(t[m][n] != -1) return t[m][n];
        
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return t[m][n] = 1 + solve(s1, s2, m-1, n-1);
        }
        else{
            return t[m][n] = 1 + Math.min(solve(s1, s2, m-1, n), 
                solve(s1, s2, m, n-1));
        }

    }
    
    public static int minSuperSeq(String s1, String s2) {
        // code here
        int m = s1.length();
        int n = s2.length();
        t = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            Arrays.fill(t[i], -1);
        }
        
        return solve(s1, s2, m, n);
    }
}


//Approach-2 (Bottom Up)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    public static int minSuperSeq(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] t = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++){
            t[i][0] = i;
        }
        for(int j = 0; j <= n; j++){
            t[0][j] = j;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1  )){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = 1 + Math.min(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[m][n];
    }
}

//Approach-2 (Bottom Up)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    public static int minSuperSeq(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] t = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    t[i][j] = i + j;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1  )){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = 1 + Math.min(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[m][n];
    }
}


// Approach-3 (Using LCS Code)
// You need to write the common letters only once and then write remaining letters of s1 and s2
// T.C : O(m*n)
// S.C : O(m*n)
class Solution {
    public static int minSuperSeq(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] t = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1  )){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        int LCS = t[m][n];
        int Len1 = m - LCS;
        int Len2 = n - LCS;
        
        return LCS + Len1 + Len2;
    }
}