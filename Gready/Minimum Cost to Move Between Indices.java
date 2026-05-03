// T.C: O(n+m)
// S.C: O(2n)
class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] closest = new int[n];

        for(int i = 0; i < n; i++){
            if(i == 0){
                closest[i] = i+1;
            }
            else if(i == n-1){
                closest[i] = i-1;
            }
            else{
                int left = Math.abs(nums[i] - nums[i-1]);
                int right = Math.abs(nums[i] - nums[i+1]);

                if(left <= right){
                    closest[i] = i-1;
                }
                else{
                    closest[i] = i+1;
                }
            }
        }

        long[] prefix = new long[n];
        long[] suffix = new long[n];

        for(int i = 0; i < n-1; i++){
            long dist = nums[i+1] - nums[i];

            long next = closest[i] == i+1 ? 1 : dist;
            long prev = closest[i+1] == i ? 1 : dist;

            prefix[i+1] = next + prefix[i];
            suffix[i+1] = prev + suffix[i];
        }
        
        int m = queries.length;
        int[] result = new int[m];

        for(int i = 0; i < m; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            if(l <= r){
                result[i] = (int) (prefix[r] - prefix[l]);
            }
            else{
                result[i] = (int) (suffix[l] - suffix[r]);
            }
        }

        return result;
    }
}