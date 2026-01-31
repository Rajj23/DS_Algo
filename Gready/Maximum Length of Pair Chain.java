// T.C: O(NlogN)
// S.C: O(1)
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) ->{
            if(a[1] != b[1]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int n = pairs.length;

        int count = 1;
        int prev = pairs[0][1];
        for(int i = 1; i < n; i++){
            if(prev < pairs[i][0]){
                count++;
                prev = pairs[i][1];
            }
        }

        return count;
    }
}