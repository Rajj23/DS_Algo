// T.C: O(n * 2^n)
// S.C: O(n)   
class Solution {
    void fun(int idx, int[] nums, List<List<Integer>> result, List<Integer> list){
        if(idx == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        fun(idx+1, nums, result, list);
        list.add(nums[idx]);
        fun(idx+1, nums, result, list);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        fun(0, nums, result, new ArrayList<>());
        return result;
    }
}