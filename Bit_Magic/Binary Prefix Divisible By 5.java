//Approach (Using bit concept and modular arithmetic)
// T.C : O(N)
// S.C : O(1)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> result = new ArrayList<>();

        int digit = 0;
        for(int i=0;i<n;i++){
            int num = nums[i];
            digit = ((digit<<1)+num)%5;
            if(digit==0){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }
}