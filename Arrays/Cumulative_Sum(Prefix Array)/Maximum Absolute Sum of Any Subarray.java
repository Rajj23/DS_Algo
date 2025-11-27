// Approach 1
// T.C : O(2N)
// S.c : O(1)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int currSubSum = nums[0];
        int maxSubSum = nums[0];

        for(int i=1;i<n;i++){
            currSubSum = Math.max(nums[i], currSubSum+nums[i]);
            maxSubSum = Math.max(maxSubSum,currSubSum);
        }

        int minSubSum = nums[0];
        currSubSum = nums[0];
        for(int i=1;i<n;i++){
            currSubSum = Math.min(nums[i], currSubSum+nums[i]);
            minSubSum = Math.min(minSubSum,currSubSum);
        }

        return Math.max(Math.abs(minSubSum),maxSubSum);
    }
}


// Approach 2
// T.C : O(N)
// S.c : O(1)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int maxSum = nums[0];
        int minSum = nums[0];

        int currSumMax = nums[0];
        int currSumMin = nums[0];

        for(int i=1;i<n;i++){
            currSumMax = Math.max(nums[i], currSumMax+nums[i]);
            maxSum = Math.max(maxSum,currSumMax);

            currSumMin = Math.min(nums[i], currSumMin+nums[i]);
            minSum = Math.min(minSum,currSumMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}