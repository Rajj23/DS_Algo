// T.C: O(n)
// S.C: O(1)
class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int idx = -1;
        int n = capacity.length;
        int val = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            if(itemSize <= capacity[i] && capacity[i] < val){
                val = capacity[i];
                idx = i;
            }
        }

        return idx;
    }
}