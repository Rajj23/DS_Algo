//Approach (Using prefix array)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        maxLeft[0] = nums[0];
        minRight[n-1] = nums[n-1];

        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(nums[i], maxLeft[i-1]);
        }

        for(int i = n-2; i >= 0; i--){
            minRight[i] = Math.min(nums[i], minRight[i+1]);
        }

        int[] ans = new int[n];
        ans[n-1] = maxLeft[n-1];

        for(int i = n-2; i >= 0; i--){
            if(maxLeft[i] <= minRight[i+1]){
                ans[i] = maxLeft[i];
            }
            else{
                ans[i] = ans[i+1];
            }
        }
        return ans;
    }
}