// T.C: O(n)
// S.C: O(n)
class Solution {

    public int smallestBalancedIndex(int[] nums) {
        long prod = 1;
        int n = nums.length;
        long[] mul = new long[n];

        for(int i = n-1; i >= 0; i--){
            mul[i] = prod;
            if(prod > (long) 1e14){
                mul[i] = (long) 2e14;
            }
            else{     
                prod *= nums[i];
            }            
        }

        long sum = 0;

        for(int i = 0; i < n; i++){
            prod /= nums[i];

            if(sum == mul[i]) return i;

            sum += nums[i];
        }

        return -1;
    }
}