//Approach (Using prefix sum)
//T.C : O(m*n)
//S.C : O(m+n)
class Solution {
    long total = 0;

    void reverse(int[][] grid){
        int top = 0;
        int bottom = grid.length-1;

        while(top < bottom){
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;

            top++;
            bottom--;
        }
    }

    boolean checkHorCuts(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        Set<Long> st = new HashSet<>();
        long top = 0;

        for(int i = 0; i <= m-2; i++){
            for(int j = 0; j < n; j++){
                st.add((long) grid[i][j]);

                top += grid[i][j];
            }

            long bottom = total - top;
            long diff = top - bottom;

            if(diff == 0) return true;
            
            if(diff == (long) grid[0][0]) return true;
            if(diff == (long) grid[0][n-1]) return true;
            if(diff == (long) grid[i][0]) return true;

            if(i > 0 && n > 1 && st.contains(diff)){
                return true;
            }
        }
        return false;
    }

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                total += grid[i][j];
            }
        }

        if(checkHorCuts(grid)){
            return true;
        }

        reverse(grid);

        if(checkHorCuts(grid)){
            return true;
        }

        reverse(grid);

        int[][] transposeGrid = new int[n][m];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                transposeGrid[j][i] = grid[i][j];
            }
        }

        if(checkHorCuts(transposeGrid)){
            return true;
        }

        reverse(transposeGrid);

        if(checkHorCuts(transposeGrid)){
            return true;
        }

    
        return false; 
    }
}