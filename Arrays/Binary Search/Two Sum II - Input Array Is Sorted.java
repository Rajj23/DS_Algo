// T.C: O(n log(n))
// S.C: O(1)
class Solution {
    int search(int l, int r, int target, int[] nums){

        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for(int i = 0; i < n; i++){
            int rem = target - numbers[i];

            int idx = search(i+1, n-1, rem, numbers);

            if(idx != -1){
                return new int[]{i+1, idx+1};
            }
        }
        return new int[]{-1, -1};
    }
}