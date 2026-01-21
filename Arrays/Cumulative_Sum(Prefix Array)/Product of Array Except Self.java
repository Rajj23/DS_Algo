// T.C: O(2n)
// S.C: O(2n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];

        suffix[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i];
        }

        int currProd = 1;
        int[] result = new int[n];

        for(int i = 0; i < n-1; i++){
            result[i] = currProd * suffix[i+1];
            currProd*= nums[i];
        }

        result[n-1] = currProd;

        return result;
    }
}