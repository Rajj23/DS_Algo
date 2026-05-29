// T.C: O(n*m)
// S.C: O(1)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        int top = 0, left = 0;

        while(top <= bottom && left <= right){
            
            // left -> right
            for(int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;

            // top -> bottom
            for(int i = top; i <= bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            // right -> left
            if (top <= bottom) {
                for(int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // bottom -> top
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }
        return result;

    }
}