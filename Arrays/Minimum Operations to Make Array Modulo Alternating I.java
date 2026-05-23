// T.C: O(k^2 * n)
// S.C: O(1)
class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;

        for(int x = 0; x < k; x++){
            for(int y = 0; y < k; y++){
                if(x == y) continue;

                int oper = 0;

                for(int i = 0; i < n; i++){
                    int mod = nums[i] % k;
                    int elem = (i%2 == 0) ? x : y;
                    int diff = Math.abs(mod - elem);

                    oper += Math.min(diff, k - diff);
                }
                ans = Math.min(ans, oper);
            }
        }
        return ans;
    }
}