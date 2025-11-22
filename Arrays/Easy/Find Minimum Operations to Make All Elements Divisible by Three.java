// T.C : O(N)
// S.c : O(1)
class Solution {
    public int minimumOperations(int[] nums) {
        int result = 0;
        for(int num:nums){
            if(num%3<2){
                result+=num%3;
            }
            else{
                result++;
            }
        }
        return result;
    }
}