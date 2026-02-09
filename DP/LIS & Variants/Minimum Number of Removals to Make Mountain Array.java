// T.C: O(n*m)
// S.C: O(n*m)
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;


        int[] lis = new int[n];
        int[] lds = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);


        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }

        for(int i = n-2; i >=0; i--){
            for(int j = n-1; j > i; j--){
                if(nums[i] > nums[j])
                    lds[i] = Math.max(lds[i], lds[j]+1);
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            if(lis[i] == 1 || lds[i] == 1) continue;

            int x = n - (lis[i] + lds[i] - 1);
            ans = Math.min(ans, x);
        }

        return ans;
    }
}