// T.C: O(n)
// S.C: O(n)
class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for(int val : mp.values()){
            freq.put(val, freq.getOrDefault(val, 0)+1);
        }

        for(int num : nums){
            int val = mp.get(num);
            if(freq.get(val) == 1){
                return num;
            }
        }

        return -1;
    }
}