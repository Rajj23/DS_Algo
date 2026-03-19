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