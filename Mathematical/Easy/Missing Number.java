// T.C: O(n)
// S.C: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = (n * (n+1))/2;

        int currSum = 0;
        for(int num : nums){
            currSum += num;
        }

        return totalSum - currSum;
    }
}