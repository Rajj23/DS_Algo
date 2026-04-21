//Approach-1 (Memoize the approach above)
//T.C : O(n^2) - Every subproblem is being computed only once and after that it's being reused
//S.C : O(n^2)
class Solution {
    Boolean[][] t;
    boolean check(int i, int j, String s){
        if(i > j){
            return true;
        }

        if(t[i][j] != null) return t[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return t[i][j] = check(i+1, j-1, s);
        }

        return t[i][j] = false;
    }
    
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        t = new Boolean[n+1][n+1];

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(check(i, j, s)){
                    count++;
                }
            }
        }
        return count;
    }
}

//Approach-3(Bottom Up - Blue Print of Pallindrome Qns)
//T.C : O(n^2)
//S.C ; O(n^2)
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        boolean[][] t = new boolean[n+1][n+1];

        for(int l = 1; l <= n; l++){
            for(int i = 0; i+l-1 < n ; i++){
                int j = i + l - 1;

                if(i == j){
                    t[i][j] = true;
                }
                else if(i+1 == j){
                    t[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    t[i][j] = ((s.charAt(i) == s.charAt(j)) && t[i+1][j-1]);
                }

                if(t[i][j] == true){
                    count++;
                }
            }
        }
        return count;
    }
}