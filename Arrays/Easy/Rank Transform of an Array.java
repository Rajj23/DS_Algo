// T.C: O(nlog(n))
// S.C: O(2n)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[][] pair = new int[n][2];

        for(int i = 0; i < n; i++){
            pair[i][0] = arr[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> {
           return Integer.compare(a[0], b[0]); 
        });

        int[] result = new int[n];

        int prev = Integer.MIN_VALUE, rank = 0;

        for(int[] p : pair){
            int num = p[0];
            int idx = p[1];

            if(num > prev){
                rank++;
            }

            result[idx] = rank;
            prev = num;
        }

        return result;
    }
}