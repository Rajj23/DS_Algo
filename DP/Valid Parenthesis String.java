// Approach 1 (recursion + memoz)
// T.C: O(n^2)
// S.C: O(n^2)
class Solution {
    Boolean[][] dp;
    boolean solve(String s,int i,int count){
        if(count<0) return false;
        if(i>=s.length()) return count==0;

        if(dp[i][count]!=null){
            return dp[i][count];
        }
        boolean result;
        if(s.charAt(i)=='('){
            result = solve(s,i+1,count+1);
        }
        else if(s.charAt(i)==')'){
            result = solve(s,i+1,count-1);
        }
        else{
            result = solve(s,i+1,count+1) || solve(s,i+1,count-1) || solve(s,i+1,count);
        }
        dp[i][count] = result;
        return result;
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n+1];
        return solve(s,0,0);
    }
}

// Approach 2 (Gready)
// T.C: O(n)
// S.C: O(1)
class Solution {
    public boolean checkValidString(String s){
        int min = 0;
        int max = 0;

        for(char c : s.toCharArray()){
            if(c=='('){
                min++;
                max++;
            }
            else if(c==')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(max<0) return false;
            if(min<0){
                min = 0;
            }
        }
        return min==0;
    }
}