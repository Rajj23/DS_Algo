
//Approach-1 (Recursion + Memoization)
//T.C : O(n*n*n)
//S.C : O(n*n)
class Solution {
    int[] t;
    int solve(int idx, String s){
        if(idx >= s.length()){
            return 0;
        }

        if(t[idx] != -1) return t[idx];

        int cuts = Integer.MAX_VALUE;

        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(idx, i, s)){
                cuts = Math.min(cuts, 1 + solve(i+1, s));
            }
        }

        return t[idx] = cuts == Integer.MAX_VALUE ? 0 : cuts;
    }

    public int minCut(String s) {
        int n = s.length();
        t = new int[n];
        pal = new Boolean[n][n];

        Arrays.fill(t, -1);
        return solve(0, s)-1;
    }
}

//Approach-2 (Bottom Up)
//T.C : O(n*n*n)
//S.C : O(n*n)
class Solution {

    Boolean[][] pal;
    boolean isPalindrome(int s, int e, String sb){
        if(s >= e) return true;

        if(pal[s][e] != null) return pal[s][e];

        if(sb.charAt(s) == sb.charAt(e)){
            return pal[s][e] = isPalindrome(s+1, e-1, sb);
        }

        return pal[s][e] = false;
    }

    public int minCut(String s) {
        int n = s.length();
        int[] t = new int[n+1];
        pal = new Boolean[n][n];

        for(int i = n-1; i >= 0; i--){
            int cost = Integer.MAX_VALUE;
            for(int j = i; j < n; j++){
                if(isPalindrome(i, j, s)){
                    cost = Math.min(cost, 1 + t[j+1]);
                }
            }
            t[i] = cost;
        }
        return t[0]-1;
    }
}