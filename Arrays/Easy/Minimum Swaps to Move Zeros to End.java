// T.C: O(n)
// S.C: O(1)
class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;

        int i = 0, j = n-1;
        int cnt = 0;
        
        while(i < j){
            if(nums[i] == 0 && nums[j] != 0){
                cnt++;
                i++;
                j--;
            }
            else if(nums[j] == 0){
                j--;
            }
            else{
                i++;
            }
        }
        return cnt;
    }
}