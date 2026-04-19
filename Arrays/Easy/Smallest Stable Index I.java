// T.C: O(n)
// S.C: O(n)
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // int[] prfix = new int[n];
        int n = nums.length;
        int[] suffix = new int[n];
        
        suffix[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            suffix[i] = Math.min(suffix[i+1], nums[i]);
        }
        int ans = -1;
        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            int min = suffix[i];

            if(max - min <= k){
                return i;
            }
        }
        return -1;
    }
}