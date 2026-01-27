// T.C: O(n * n!)
// S.C: O(n)  
class Solution {
    void fun(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> list){

        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);
            fun(nums, visited, result, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];

        fun(nums, visited, result, new ArrayList<>());
        return result;
    }
}