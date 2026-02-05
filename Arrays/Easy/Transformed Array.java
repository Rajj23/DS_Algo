// T.C: O(n)
// S.C: O(n)
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            int num = nums[i];

            if(num < 0){
                num = Math.abs(num);
                result[i] = nums[(i- (num%n) + n) % n];
            }
            else if(num > 0){
                num = Math.abs(num);
                result[i] = nums[(i + num) %n];
            }
            else{
                result[i] = num;
            }
        }

        return result;
    }
}