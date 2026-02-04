// Approach: Memoization
// T.C: O(n)
// S.C: O(2n)
class Solution {
    // Function to calculate the number of subsets with a given sum
    int[][] t;
    int solve(int idx, int[] nums, int target){
        
        if(idx == nums.length){
            if(target == 0) return t[idx][target] = 1;
            return 0;
        }
        
        if(t[idx][target] != -1) return t[idx][target];
        
        int take = 0;
        if(target >= nums[idx]){
            take = solve(idx+1, nums, target - nums[idx]);
        }
        int notTake = solve(idx+1, nums, target);
        
        return t[idx][target] = take + notTake;
        
    }
    
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        t = new int[n+1][target+1];
        
        for(int i = 0; i <= n; i++){
            Arrays.fill(t[i], -1);
        }
        
        return solve(0, nums, target);
    }
}


// Approach: Tabulization
// T.C: O(n)
// S.C: O(2n)
class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] t = new int[n+1][target+1];
        
        t[n][0] = 1;
        
        for(int i = n-1; i >= 0; i--){
            for(int tar = 0; tar <= target; tar++){
                int take = 0;
                if(tar >= nums[i]){
                    take = t[i+1][tar - nums[i]];
                }
                
                int notTake = t[i+1][tar];
                
                t[i][tar] = take + notTake;
            }
        }
        
        return t[0][target];
    }
}