// T.C: O(2^n)
// S.C: O(target)
class Solution {
    void fun(int idx, int target, int[] candidates, List<List<Integer>> result, List<Integer> list){
        if(idx == candidates.length || target <= 0){
            if(target == 0){
                result.add(new ArrayList<>(list));
            }

            return;
        }

        list.add(candidates[idx]);
        fun(idx, target-candidates[idx], candidates , result, list);
        list.remove(list.size() - 1);
        fun(idx+1, target,candidates, result, list);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        fun(0, target, candidates, result, new ArrayList<>());

        return result;
    }
}