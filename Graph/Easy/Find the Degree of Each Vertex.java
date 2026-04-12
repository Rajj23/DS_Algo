// T.C: O(n*n)
// S.C: O(n)
class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix[0].length;       

        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(matrix[i][j] == 1){
                    result[i]++;
                    result[j]++;
                }
            }
        }
        return result;
    }
}