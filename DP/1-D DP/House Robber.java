// Approach 1: rec + memo
// T.C: O(n)
// S.C: O(n)
class Solution {
    int[] t;
    int solve(int idx, int[] nums){
        if(idx >= nums.length) return 0;

        if(t[idx] != -1) return t[idx];

        int pick = solve(idx+2, nums) + nums[idx];
        int notPick = solve(idx+1, nums);

        return t[idx] = Math.max(pick, notPick);
    }
        int n = nums.length;

        t = new int[n];
        Arrays.fill(t, -1);

        return solve(0, nums);
    }
}


// Approach 2: bottom-up
// T.C: O(n)
// S.C: O(n)
class Solution {
    public int rob(int[] nums){
        int n = nums.length;
        int[] t = new int[n+2];

        t[n] = 0;
        t[n+1] = 0;
        for(int i = n-1; i >= 0; i--){
            int pick = nums[i] + t[i+2];
            int notPick = t[i+1];

            t[i] = Math.max(pick, notPick);
        }

        return t[0];
    }
}

// Approach 3: constant space
// T.C: O(n)
// S.C: O(1)
class Solution {
   
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 1) return nums[0];
        
        int prePrev = 0;
        int prev = nums[0];

        for(int i = 2; i <= n; i++){
            int take = nums[i-1] + prePrev;
            int skip = prev;

            int temp = Math.max(take, skip);

            prePrev = prev;
            prev = temp;
        }

        return prev;
    }
}