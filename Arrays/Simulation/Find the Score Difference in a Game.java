// T.C: O(n)
// S.C: O(1)
class Solution {
    public int scoreDifference(int[] nums) {
        int odd = 0;
        int even = 0;
        int n = nums.length;
        boolean swap = true;

        for(int i = 0; i < n; i++){
            if(nums[i] % 2 != 0){
                swap = !swap;
            }
            
            if(i%6 == 5){
                swap = !swap;
            }
            int num = nums[i];
            if(swap == true){
                odd += num;
            }
            else{
                even += num;
            }
        }

        return odd - even;
    }
}