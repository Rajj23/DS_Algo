// Approach: Top down
// T.C: O(n^2)
// S.C: O(n^2)
class Solution {
    int n;

    int[] t;
    int solve(int i, int[] nums, int target){
        if(i == n-1){
            return 0;
        }

        if(t[i] != Integer.MIN_VALUE) return t[i];

        int jump = -1;
        for(int idx = i+1; idx < n; idx++){
            if(Math.abs((long) nums[idx] - nums[i]) <= target){
                int next = solve(idx, nums, target);
                if(next != -1){
                    jump = Math.max(jump, 1+next);
                }
            }
        }
        return t[i] = jump;
    }
    public int maximumJumps(int[] nums, int target) {
        n = nums.length;

        t = new int[n+1];
        Arrays.fill(t, Integer.MIN_VALUE);
        return solve(0, nums, target);
    }
}


// Approach: Bottom up
// T.C: O(n^2)
// S.C: O(n^2)
class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] t = new int[n];

        for(int i = n-2; i >= 0; i--){
            int jump = -1;
            for(int idx = i+1; idx < n; idx++){
                if(Math.abs((long) nums[idx] - nums[i]) <= target){
                    int next = t[idx];
                    if(next != -1){
                        jump = Math.max(jump, 1+next);
                    }
                }
            }
            t[i] = jump;
        }

        return t[0];
    }
}