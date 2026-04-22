//Approach-1 (Memoize the approach)
// T.C: O(n*n)
// S.C: O(n*n)
class Solution {
    Boolean[][] t;
    boolean valid(int i, int j, String s){
        if(i > j) return true;
        if(t[i][j] != null) return t[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return t[i][j] = valid(i+1, j-1, s);
        }

        return t[i][j] = false;
    }

    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();
        t = new Boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(valid(i, j, s)){
                    String sb = s.substring(i, j+1);
                    if(ans.length() < sb.length()){
                        ans = sb;
                    }
                }
            }
        }

        return ans;
    }
}

//Approach-2(Bottom Up - Blue Print of Pallindrome Qns)
// T.C: O(n*n)
// S.C: O(n*n)
class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();
        boolean[][] t = new boolean[n][n];
        

        for(int l = 1; l <= n; l++){
            for(int i = 0; i+l-1 < n ;i++){
                int j = i + l - 1;

                if(i == j){
                    t[i][j] = true;
                }
                else if(i+1 == j){
                    t[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    t[i][j] = s.charAt(i) == s.charAt(j) && t[i+1][j-1];
                }

                if(t[i][j] == true && ans.length() < l){
                    ans = s.substring(i, j+1); 
                }
            }
        }
        return ans;
    }
}