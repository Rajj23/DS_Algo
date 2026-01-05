// T.C: O(row*col)
// S.C: O(1)
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long result = 0;
        int n = matrix.length;
        int negCount = 0;
        int minValue = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result += Math.abs(matrix[i][j]);

                if(matrix[i][j] < 0){
                    negCount++;
                }

                minValue = Math.min(minValue, Math.abs(matrix[i][j]));
            }
        }

        if(negCount%2 != 0){
            return result - 2*minValue;
        }

        return result;
    }
}