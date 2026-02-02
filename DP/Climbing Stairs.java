// Approach : Memoization
// T.C : O(n)
// S.C : O(n)
class Solution {
    int[] t;
    int solve(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(t[n] != -1) return t[n];

        int total = 0;
        total += solve(n - 1);
        total += solve(n - 2); 

        return t[n] = total;
    }

    public int climbStairs(int n) {
        t = new int[n+1];
        Arrays.fill(t, -1);

        return solve(n);
    }
}

// Approach : Tabulization
// T.C : O(n)
// S.C : O(n)
class Solution {
    public int climbStairs(int n) {
        int[] t = new int[n+1];
        t[0] = 1;

        for(int i = 1; i <= n; i++){
            int total = t[i-1];
            int y = 0;
            if(i > 1){
                y = t[i-2];
            }

            t[i] = y + total;
        }
        return t[n];
    }
}