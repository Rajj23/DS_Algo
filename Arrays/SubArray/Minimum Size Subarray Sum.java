// T.C: O(n)
// S.C: O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int currSum = 0;
        int result = Integer.MAX_VALUE;

        while(j<n){
            currSum += nums[j];

            while(currSum>= target){
                result = Math.min(result, j-i+1);
                currSum -= nums[i];
                i++;
            }
            j++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}