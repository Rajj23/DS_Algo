// Approach
// Use recursion (DFS) over indices. For each index, either include the current
// element in the running sum or exclude it, and recurse to the next index.
// When we reach the end of the array, we add the accumulated sum to the list
// of results. This explores all possible subsets and records their sums.
// T.C: O(2^n) where n is the size of the array, since each element has 2 choices.
// S.C: O(n) auxiliary recursion stack, and O(2^n) for the output list of sums.
class Solution {
    void fun(int idx, int[] arr, ArrayList<Integer> result, int sum){
        if(idx == arr.length){
            result.add(sum);
            return;
        }
        int newSum = sum + arr[idx];
        fun(idx+1, arr, result, newSum);
        fun(idx+1, arr, result, sum);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        fun(0, arr, result, 0);
        return result;
    }
}