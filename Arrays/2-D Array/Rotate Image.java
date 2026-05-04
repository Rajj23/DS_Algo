// T.C: O(n*n)
// S.C: O(1)
class Solution {
    void reverse(int[] matrix){
        int n = matrix.length;
        int i = 0, j = n-1;
        while(i < j){
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            reverse(matrix[i]);
        }
    }
}