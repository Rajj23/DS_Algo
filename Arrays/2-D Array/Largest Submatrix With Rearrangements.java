// T.C: O(m*n*log(n))
// S.C: O(m*n)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxArea = 0;

        for(int row = 0; row < m ; row++){
            for(int col = 0; col < n; col++){

                if(matrix[row][col] == 1 && row > 0){
                    matrix[row][col] += matrix[row-1][col];
                }
            }
            int[] heights = matrix[row].clone();
            Arrays.sort(heights);

            for(int s = 0; s < n; s++){
                int base = (n - s);
                int height = heights[s];

                maxArea = Math.max(maxArea, base * height);
            }
        }
        return maxArea;
    }
}


class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] prevRow = new int[n];

        int maxArea = 0;

        for(int row = 0; row < m ; row++){
            int[] currRow = matrix[row];

            for(int col = 0; col < n; col++){

                if(matrix[row][col] == 1){
                    currRow[col] += prevRow[col];
                }
            }
            int[] heights = currRow;
            Arrays.sort(heights);

            for(int s = 0; s < n; s++){
                int base = (n - s);
                int height = heights[s];

                maxArea = Math.max(maxArea, base * height);
            }
            prevRow = currRow;
        }
        return maxArea;
    }
}