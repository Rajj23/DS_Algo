// T.C: O(n*log(m))
// S.C: O(1)
class Solution {
    int sumNum(int num){
        int sum = 0;

        while(num != 0){
            sum += (num%10);
            num /= 10; 
        }
        return sum;
    }

    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for(int num : nums){
            ans = Math.min(ans, sumNum(num));
        }

        return ans;
    }
}