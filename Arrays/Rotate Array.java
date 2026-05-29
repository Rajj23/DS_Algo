// T.C: O(2n)
// S.C: O(1)
class Solution {
    void rev(int start, int end, int[] nums){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k %= n;

        rev(0, n-1, nums);
        rev(0, k-1, nums);
        rev(k, n-1, nums);
    }
}