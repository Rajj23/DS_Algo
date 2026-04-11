// T.C: O(n * log10(max(nums)))
// S.C: O(1)
class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for(int num : nums){
            while(num > 0){
                int dig = num % 10;
                num /= 10;
                if(dig == digit) count++;
            }
        }
        return count;
    }
}