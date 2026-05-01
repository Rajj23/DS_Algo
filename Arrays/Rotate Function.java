//Approach (Compute relation and find F(K+1) from F(K) and so on
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int maxRotateFunction(int[] nums) {
        int ans = 0;
        int sum = 0;
        int f = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            f += (nums[i] * i);
        }
        ans = f;

        for(int k = 0; k < n-1; k++){
            int newF = f + sum - (n*nums[n-1-k]);
            ans = Math.max(ans, newF);
            f = newF;
        }
        return ans;
    }
}