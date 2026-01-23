// T.C: O(log(n))
// S.C: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m-1;
        int row = -1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(matrix[mid][0] <= target && target <= matrix[mid][n-1]){
                row = mid;
                break;
            }
            else if(matrix[mid][0] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        if(row == -1) return false;

        low = 0;
        high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}