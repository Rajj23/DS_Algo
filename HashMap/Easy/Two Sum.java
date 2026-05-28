// T.C: O(n)
// S.C: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int req = target - nums[i];

            if(mp.containsKey(req)){
                int val = mp.get(req);
                return new int[]{i, val};
            }
            else{
                mp.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}