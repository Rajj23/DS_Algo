class Solution {
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(maxIdx<i) return false;
            
            maxIdx = Math.max(maxIdx,i+nums[i]);

        }

        return true;
    }
}