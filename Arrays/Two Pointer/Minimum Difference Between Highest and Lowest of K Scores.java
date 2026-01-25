//Approach (Using sorting and two pointers)
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        
        int i = 0, j = k-1;

        while(j < n){
            int diff = nums[j] - nums[i];
            result = Math.min(diff, result);
            j++;
            i++;
        }

        return result;
    }   
}