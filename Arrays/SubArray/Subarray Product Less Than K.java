// T.C: O(n)
// S.C: O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        
        int i = 0, j = 0;
        int currMul = 1;
        int n = nums.length;
        int result = 0;

        while(j < n){
            currMul *= nums[j];
            
            while(currMul >= k){
                currMul /= nums[i];
                i++;
            }
            result +=  (j-i+1);
            j++;  
        }
        return result;
    }
}