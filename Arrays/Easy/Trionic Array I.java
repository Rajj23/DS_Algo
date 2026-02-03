// T.C: O(n)
// S.C: O(1)
class Solution {
    public boolean isTrionic(int[] nums) {
        boolean dec = false;
        int count = 0;
        if (nums.length < 3 || nums[1] <= nums[0]) return false;


        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) return false;
            if(count == 0){
                if(nums[i] < nums[i-1])
                    count = 1;

            }
            else if(count == 1){
                if(nums[i] > nums[i-1]){
                    count = 2;
                }
            }
            else {
                if(nums[i] < nums[i-1]) return false;
            }
        }
        return count == 2;
    }
}



// T.C: O(n)
// S.C: O(1)
class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums[0] > nums[1]) return false;
        boolean dec = false;
        boolean repeat = false;
        int n = nums.length;

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1]) return false;
            if(nums[i-1] > nums[i]){
                if(repeat) return false;
                dec = true;
            }
            else if(nums[i-1] < nums[i]){
                if(dec) 
                    repeat = true;
            }
        }

        return dec && repeat;
    }
}