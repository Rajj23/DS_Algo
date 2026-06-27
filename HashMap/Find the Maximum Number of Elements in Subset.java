//T.C : O(n * log log M), M = maximum number in the nums
//S.C : O(n)
class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put((long) num, mp.getOrDefault((long) num, 0)+1);
        }

        int result = 0;

        int one = mp.getOrDefault(1L, 0);
        result = (one % 2 == 1) ? one : one - 1;

        for(long curr :  mp.keySet()){
            long num = curr;

            if(num == 1) continue;

            int len = 0;

            while(mp.getOrDefault(num, 0) > 1){
                len += 2;
                num = num * num;
            }

            len += mp.containsKey(num) ? 1 : -1;
            

            result = Math.max(result, len);
        }

        return result;
    }
}