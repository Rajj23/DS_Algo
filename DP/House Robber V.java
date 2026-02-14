// T.C: O(n)
// S.C: O(n)
class Solution {
    long[][] t;
    long solve(int i, int prev, int[] nums, int[] colors){
        if(i >= nums.length) return 0;

        if(t[i][prev] != -1) return t[i][prev];

        long notTake =  0 + solve(i+1, 0, nums, colors);
        
        long take = 0;
        if(prev == 0 || colors[i] != colors[i-1]){
            take = nums[i] + solve(i+1, 1, nums, colors);
        }

        return t[i][prev] = Math.max(take, notTake);
    }
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        t = new long[n][2];
        for(int i = 0; i < n; i++){
           Arrays.fill(t[i], -1);
        }
        
        return solve(0, 0, nums, colors);
    }
}