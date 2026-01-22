// Approach: 1
// T.C: O(3n)
// S.C: O(2n)
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;

        int[] leftMax = new int[n];
        int[] rightMin = new int[n+1];

        rightMin[n] = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--){
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);
        }

        leftMax[0] = nums[0];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], nums[i]);
        }

        for(int i = 0; i < n-1; i++){
            if(leftMax[i] <= rightMin[i+1]){
                return i+1;
            }
        }
        return 0;
    }
}


// Approach: 2
// T.C: O(2n)
// S.C: O(n)
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;

        int[] rightMin = new int[n+1];

        rightMin[n] = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--){
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);
        }

        int leftMax = Integer.MIN_VALUE;
        for(int i = 0; i < n-1; i++){
            leftMax = Math.max(leftMax, nums[i]);
            if(leftMax <= rightMin[i+1]){
                return i+1;
            }
        }
        return 0;
    }
}