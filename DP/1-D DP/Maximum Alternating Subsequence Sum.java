// T.C: O(n)   
// S.C: O(n)
class Solution {
    long[][] t;
    long solve(int[] nums, int idx, int isEven){
        if(idx == nums.length){
            return 0;
        }

        if(t[idx][isEven] != -1) return t[idx][isEven];

        long skip = solve(nums, idx+1, isEven);

        long pick = 0;

        if(isEven == 1){
            pick = nums[idx] + solve(nums, idx+1, 0);
        }
        else{
            pick = -nums[idx] + solve(nums, idx+1, 1);
        }

        return t[idx][isEven] = Math.max(pick, skip);
    }
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        t = new long[n+1][2];
        for(int i = 0; i <= n; i++){
            Arrays.fill(t[i], -1);
        }
        return solve(nums, 0, 1);
    }
}

// Approach 2: bottom up
// T.C: O(n)
// S.C: O(n)
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] t = new long[n+1][2];

        for(int idx = n-1; idx >= 0; idx--){
            for(int isEven = 0; isEven <= 1; isEven++){
                
                long skip = t[idx+1][isEven];

                int num = nums[idx];
                if(isEven != 1){
                    num *= -1;
                }

                long take = t[idx+1][1 - isEven] + num;

                t[idx][isEven] = Math.max(skip, take);
            }
        }
        return t[0][1];
    }
}


// Approach 3: bottom up
// T.C: O(n)
// S.C: O(n)
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        long[][] t = new long[n+1][2];

        for(int i = 1; i < n+1; i ++){

            t[i][0] = Math.max(t[i-1][1] - nums[i-1], t[i-1][0]);

            t[i][1] = Math.max(t[i-1][0] + nums[i-1], t[i-1][1]);
        }

        return Math.max(t[n][0], t[n][1]);
    }
}