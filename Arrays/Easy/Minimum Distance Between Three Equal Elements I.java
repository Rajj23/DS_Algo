// T.C: O(n*n*n)
// S.C: O(1)
class Solution {
    public int minimumDistance(int[] nums) {
        if(nums.length < 3) return -1;

        int result = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        int val = Math.abs(i-j) + Math.abs(j-k) + Math.abs(k-i);
                        result = Math.min(result, val);
                    }
                }
            }
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }
}