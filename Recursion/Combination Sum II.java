// T.C: O(2^n)
// S.C: O(target)
class Solution {
    void fun(int idx, int target,int[] nums, List<List<Integer>> result, List<Integer> list){
        if(idx == nums.length || target <= 0){
            if(target == 0){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(nums[idx]);
        fun(idx+1,target - nums[idx], nums, result, list);
        list.remove(list.size() - 1);
        
        int nextIdx = idx + 1;
        while (nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
            nextIdx++;
        }

        fun(nextIdx, target, nums, result, list);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        fun(0, target, candidates, result,new ArrayList<>());
        return result;
    }
}