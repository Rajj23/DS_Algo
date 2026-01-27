// T.C: O(n * 2^n)
// S.C: O(n * 2^n)
class Solution {
    void fun(int idx, int[] nums, List<List<Integer>> result, List<Integer> list){
        if(idx == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        fun(idx+1, nums, result, list);
        list.remove(list.size() - 1);
        
        int nextIdx = idx;
        while(nextIdx < nums.length && nums[nextIdx] == nums[idx]){
            nextIdx++;
        }
        fun(nextIdx, nums, result, list);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        fun(0,nums,result, new ArrayList<>());
        return result;
    }
}