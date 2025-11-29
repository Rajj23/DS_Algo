// T.C: O(N)
// S.C: O(1)
class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;

        for(int num:nums){
            sum = (sum + num)%k;
        }

        return sum;
    }
}