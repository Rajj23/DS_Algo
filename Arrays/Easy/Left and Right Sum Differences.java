// T.C: O(n)
// S.C: O(n)
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int leftSum = 0;
        int rightSum[] = new int[n];

        int sum = 0;
        for(int j = n-1; j >= 0; j--){
            rightSum[j] = sum;
            sum += nums[j];
        }

        for(int i = 0; i < n; i++){
            result[i] = Math.abs(leftSum - rightSum[i]);
            leftSum += nums[i];
        }

        return result;
    }
}