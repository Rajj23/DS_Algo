//Approach-1 (Using Recursion + Memoization)
// T.C: O(n)
// S.C: O(n)
class Solution {
    int solve(int n, int[] dp){
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        return dp[n] = solve(n-1, dp) + solve(n-2, dp);
    }

    public int fib(int n) {
        if(n <= 1) return n;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }
}

//Approach-2 (Using Bottom Up DP)
// T.C: O(n)
// S.C: O(n)
class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        int[] nums = new int[n+1];
        Arrays.fill(nums, -1);

        nums[0] = 0;
        nums[1] = 1;

        for(int i = 2; i <= n; i++){
            nums[i] = nums[i-1] + nums[i-2];
        }

        return nums[n];
    }
}


//Approach-3 (Constant Space Complexity)
// T.C: O(n)
// S.C: O(n)
class Solution {
    public int fib(int n) {
        if(n <= 1) return n;

        int a = 0;
        int b = 1;
        int c = 0;

        for(int i = 1; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}