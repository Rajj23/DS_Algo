// Memoization
// T.C : O(n)
// S.C : O(n)
class Solution {
    Boolean[] t;
    boolean solve(int idx, int[] nums){
        if(idx >= nums.length - 1) return t[idx] = true;

        if(t[idx] != null) return t[idx];

        if(nums[idx] == 0) return t[idx] = false;

        for(int i = 1; i <= nums[idx]; i++){
            if(solve(idx+i, nums)){
                return t[idx] = true;
            }
        }
        return t[idx] = false;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        t = new Boolean[n+1];

        return solve(0, nums);
    }
}

// Tabulaization
// T.C : O(n)
// S.C : O(n)
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] t = new boolean[n];
        t[n-1] = true;


        for(int i = n-2; i >= 0; i--){
            for(int k = 1; k <= nums[i] && i + k < n; k++){
                if(t[i + k]){
                    System.out.println(i + " " + t[i]);
                    t[i] = true;
                    break;
                }
            }
        }
        return t[0];
    }
}