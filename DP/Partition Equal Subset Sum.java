// Approach: Memoization
// T.C: O(n)
// S.C: O(2n)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        if (totalSum % 2 != 0) return false;
        int target = totalSum/2;
        boolean[][] t = new boolean[n+1][target+1];

        for(int i = 0; i <= n; i++){
            t[i][0] = true;
        }

        for(int i = n-1; i>= 0; i--){
            for(int sum = 1; sum <= target; sum++){
                
                boolean take = false;
                if(sum >= nums[i]){
                    take = t[i+1][sum-nums[i]];
                }

                boolean notTake = t[i+1][sum];
                t[i][sum] = take || notTake;
            }
        }

        return t[0][target];
    }
}

