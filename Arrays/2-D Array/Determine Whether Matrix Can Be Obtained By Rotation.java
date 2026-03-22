// T.C: O(n*n)
// S.C: O(1)
class Solution {
    void reverse(int[] nums){
        int i = 0, j = nums.length - 1;

        while(i <= j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    void rotate(int[][] mat){
        int n = mat.length;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            reverse(mat[i]);
        }
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for(int c = 1; c <= 4; c++){

            boolean equal = true;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(mat[i][j] != target[i][j]){
                        equal = false;
                        break;
                    }
                }
                if(!equal) break;
            }
            if(equal == true) return true;

           rotate(mat);
        }
        return false;
    }
}