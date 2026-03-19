// Approach 1: rec + memo
// T.C: O(2*n)
// S.C: O(n)
class Solution {
    int solve(int idx, int n, int[] nums, int[] t){
        if(idx >= n) return 0;

        if(t[idx] != -1) return t[idx];

        int take = nums[idx] + solve(idx+2, n, nums, t);

        int skip = solve(idx+1, n, nums, t);
        
        return t[idx] =Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] t1 = new int[101];
        Arrays.fill(t1, -1);

        int zero = solve(0, n-1, nums, t1);

        Arrays.fill(t1, -1);
        int one = solve(1, n, nums, t1);

        return Math.max(zero, one);
    }
}


// Approach 2: bottom up
// T.C: O(2*n)
// S.C: O(n)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);


        int[] t = new int[n+1];

        t[0] = 0;
        t[1] = nums[0];

        for(int i = 2; i <= n-1; i++){
            int take = nums[i-1] + t[i-2];
            int skip = t[i-1];

            t[i] = Math.max(take, skip);
        }

        int result = t[n-1];

        Arrays.fill(t, 0);
        t[1] = 0;
        t[2] = nums[1];

        for(int i = 3; i <= n; i++){
            int take = nums[i-1] + t[i-2];
            int skip = t[i-1];

            t[i] = Math.max(take, skip);
        }

        return Math.max(result, t[n]);
    }
}


// Approach 3: constant space
// T.C: O(n)
// S.C: O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int prevPrev = 0;
        int prev = nums[0];

        for(int i = 2; i <= n-1; i++){
            int take = nums[i-1] + prevPrev;
            int skip = prev;

            int temp = Math.max(take, skip);

            prevPrev = prev;
            prev = temp;
        }

        int result = prev;

        prevPrev = 0;
        prev = nums[1];

        for(int i = 3; i <= n; i++){
            int take = nums[i-1] + prevPrev;
            int skip = prev;

            int temp = Math.max(take, skip);
            prevPrev = prev;
            prev = temp;
        }

        return Math.max(result, prev);
    }
}