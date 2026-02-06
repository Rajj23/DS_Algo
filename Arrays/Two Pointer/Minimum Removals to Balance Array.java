// T.C: O(2*n)
// S.C: O(1)
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;

        if(n == 1) return 0;

        Arrays.sort(nums);


        int L = 1;
        int maxEl = nums[0];
        int minEl = nums[0];

        int i = 0;
        int j = 1;
        while(j < n){
            minEl = nums[i];
            maxEl = nums[j];
            
            while(i < j && maxEl >(long) k*minEl){
                i++;
                minEl = nums[i];
            }

            L = Math.max(L, j-i+1);
            j++;
        }

        return n-L;
    }
}



// T.C: O(2*n)
// S.C: O(1)
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;

        if(n == 1) return 0;

        Arrays.sort(nums);

        int i = 0;
        int j = 1;

        int ans = Integer.MAX_VALUE;

        while(j < n && i <= j){
            if((long) nums[i] * k >= nums[j]){
                int currSize = j - i + 1;
                ans = Math.min(ans, n - currSize);
                j++;
            }
            else{
                i++;
            }
        }

        return ans;
    }
}