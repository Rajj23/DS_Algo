// T.C: O(m * n)
// S.C: O(1)
class Solution {
    boolean even(int i, int[][] mat, int k){
        int n = mat[0].length;

        for(int j = 0; j < n; j++){
            int idx = (n + j + k) % n;

            if(mat[i][j] != mat[i][idx]) return false;
        }

        return true;
    }

    boolean odd(int i, int[][] mat, int k){
        int n = mat[0].length;

        for(int j = n-1; j >= 0; j--){
            int idx = (n+j-k) % n;

            if(mat[i][j] != mat[i][idx]) return false;
        }

        return true;
    }
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k = k % n;

        for(int i = 0; i < m; i++){
            if(i%2 == 0 && !even(i, mat, k)){
                return false;
            }
            else if(!odd(i, mat, k)){
                return false;
            }
        }

        return true;
    }
}