// T.C: O(maxEl + n)
// S.C: O(maxEl)
class Solution {
    public long minArraySum(int[] nums) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        max++;

        int[] freq = new int[max];
        for(int num : nums){
            freq[num]++;
        }

        int[] sieve = new int[max];
        for(int i = 0; i < max; i++){
            sieve[i] = i;
        }

        for(int i = 1; i < max; i++){
            if(freq[i] == 0) continue;

            for(int mul = i; mul < max; mul += i){
                if(freq[mul] > 0){
                    sieve[mul] = Math.min(sieve[mul], i);
                }
            }
        }

        long result = 0;
        for(int i = 0; i < max; i++){
            if(freq[i] > 0){
                result += (long) freq[i] * sieve[i];
            }
        }

        return result;
    }
}