// Approach : Memoization
// T.C : O(n)
// S.C : O(n)
class Solution {
    int[] t;
    int solve(int idx, int[] nums){
        if(idx >= nums.length-1) return 0;

        if(t[idx] != -1) return t[idx];

        int val = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[idx]; i++){
            int curr = solve(idx+i, nums);
            if(curr != Integer.MAX_VALUE){
                val = Math.min(val, curr+1);
            }
        }

        return t[idx] = val;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        t = new int[n];
        Arrays.fill(t, -1);
        return solve(0, nums);
    }
}

// Approach : Tabulization
// T.C : O(n)
// S.C : O(n)
class Solution{
    public int jump(int[] nums) {
        int n = nums.length;
        int[] t = new int[n];
        t[n-1] = 0;

        for(int i = n-2; i >= 0; i--){
            int val = Integer.MAX_VALUE;
            for(int k = 1; k <= nums[i]; k++){
                if(i+k >= n) continue;
                int curr = t[i+k];
                if(curr != Integer.MAX_VALUE){
                    val = Math.min(curr+1, val);
                }
            }
            t[i] = val;
        }
        return t[0];
    }
}