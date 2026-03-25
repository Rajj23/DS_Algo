// Approach 1: brute force
// T.C: O(2*m*n)
// S.C: O(m+n)
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] col = new long[n];
        long[] row = new long[m];

        long totalColSum = 0;
        long totalRowSum = 0;
        for(int i = 0; i < m; i++){
            long rowSum = 0;
            for(int j = 0; j < n; j++){
                rowSum += grid[i][j];
            }
            row[i] = rowSum;
            totalRowSum += rowSum;
        }
        System.out.println(totalRowSum);
        for(int j = 0; j < n; j++){
            long colSum = 0;
            for(int i = 0; i < m; i++){
                colSum += grid[i][j];
            }
            col[j] = colSum;
            totalColSum += colSum;
        }
        System.out.println(totalColSum);
        long prevRowSum = 0;
        for(int i = 1; i < m; i++){
            prevRowSum += row[i-1];
            totalRowSum -= row[i-1];

            if(prevRowSum == totalRowSum) return true;
        }

        long prevColSum = 0;
        for(int j = 1; j < n; j++){
            prevColSum += col[j-1];
            totalColSum -= col[j-1];

            if(prevColSum == totalColSum) return true;
        }

        return false;
    }
}


// Approach 1: brute force
// T.C: O(m*n)
// S.C: O(m+n)
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] col = new long[n];
        long[] row = new long[m];

        long total = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                total += grid[i][j];

                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }
        
        long prevRowSum = 0;
        for(int i = 0; i < m-1; i++){
            prevRowSum += row[i];

            if(prevRowSum == total - prevRowSum) return true;
        }

        long prevColSum = 0;
        for(int j = 0; j < n-1; j++){
            prevColSum += col[j];

            if(prevColSum == total - prevColSum) return true;
        }

        return false;
    }
}