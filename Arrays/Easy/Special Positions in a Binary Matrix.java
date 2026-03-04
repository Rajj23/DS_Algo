// T.C: O((n * m) + (m + n))
// S.C: O(1)
class Solution {
    boolean isValidRow(int row, int[][] mat, int n){
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += mat[row][i];

            if(sum > 1) return false;
        }

        return true;
    }

    boolean isValidCol(int col, int[][] mat, int m){
        int sum = 0;

        for(int i = 0; i < m; i++){
            sum += mat[i][col];

            if(sum > 1) return false;
        }

        return true;
    }

    public int numSpecial(int[][] mat) {
        
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    int sum = 0;

                    if(isValidRow(i, mat, n) && isValidCol(j, mat, m)){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}



// T.C: O(2 (m * n))
// S.C: O(m * n)
class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat[0].length;
        int m = mat.length;

        int[] row = new int[m];
        int[] col = new int[n];
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    if(row[i] == 1 && col[j] == 1){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}