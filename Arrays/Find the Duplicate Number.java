// T.C: O(n)
// S.C: O(n)
class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0)+1);
            if(mp.get(num) == 2) return num;
        }

        return -1;
    }
}