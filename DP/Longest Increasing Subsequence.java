// Approach: Recursion
// T.C: O(2^n)
// S.C: O(1)
class Solution {
    int solve(int i, int prev, int[] nums){
        if(i == nums.length) return 0;

        int pick = 0;
        if(nums[i] > prev){
            pick = 1 + solve(i+1, nums[i], nums);
        }

        int notPick = solve(i+1, prev, nums);

        return Math.max(pick, notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, solve(i, Integer.MIN_VALUE, nums));
        }        

        return max;
    }
}



// T.C: O(n*n)
// S.C: O(n)
class Solution{
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] t = new int[n];

        Arrays.fill(t, 1);

        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    t[i] = Math.max(t[i], t[j]+1);
                }
            }
            ans = Math.max(ans, t[i]);
        }

        return ans;
    }
}