// T.C: O(n)
// S.C: O(1)
class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];
        int odd = 0;
        int even = 0;

        for(int i = n-1; i >= 0; i--){
            int num = nums[i];
            if(num%2==0){
                result[i] = odd;
                even++;
            }
            else{
                result[i] = even;
                odd++;
            }
        }
        
        return result;
    }
}