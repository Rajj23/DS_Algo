// T.C: O(n)
// S.C: O(n)
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        int[] nums = new int[n];
        nums[0] = 1;
        for(int i = 1; i < n; i++){
            if(Math.abs(nums[i-1] - arr[i]) <= 1){
                nums[i] = arr[i];
            }
            else{
                nums[i] = nums[i-1] + 1;
            }
        }

        int ans = -1;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, nums[i]);
        }

        return ans;
    }
}