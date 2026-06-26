// T.C: O(m*n*logn)
// S.C: O(1)
import java.util.*;
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int l = matrix[0][0];
        int r = matrix[n-1][n-1];

        List<Integer> list = new ArrayList<>();
        list.toArray();

        while(l <= r){
            int mid = l + (r - l)/2;
            int count = 0;

            for(int row = 0; row < n; row++){
                int col = n -1;
                while(col >= 0 && matrix[row][col] > mid){
                    col--;
                }

                count += col + 1;
            }

            if(count < k){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return l;
    }
}