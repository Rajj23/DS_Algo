// T.C: O(2n)
// S.C: O(2n)
class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] result = new int[2*n];

        int i = 0;
        for(; i < n; i++){
            result[i] = nums[i];
        }
        int idx = n-1;

        for( ; i < 2*n; i++){
            result[i] = nums[idx--];
        }

        return result;
    }
}