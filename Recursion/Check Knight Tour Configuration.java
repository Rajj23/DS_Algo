// Approach: Simulate the given tour starting from (0,0). First
// check that grid[0][0] is 0. Then, from the current knight
// position and current step count, try all 8 possible knight moves
// to find the cell that contains the next number (count + 1).
// If we can follow such valid knight moves all the way up to
// value n*n - 1, the configuration is a valid knight tour.
// T.C: O(n^2 * 8) ≈ O(n^2), since for each of the n^2 positions
// we check up to 8 possible moves.
// S.C: O(n^2) in the worst case due to recursion depth (and O(1)
// extra space aside from the input grid and constant direction arrays).
class Solution {
    int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] dc = {-1,  1, -2,  2, -2, 2, -1, 1};

    boolean isValid(int row, int col, int n){
        return row >= 0 && col >= 0 && row < n && col < n;
    }

    boolean fun(int row, int col, int[][] grid, int count){
        int n = grid.length;
        if(grid[0][0] != 0) return false;

        if(count == n*n - 1){
            return true;
        }
        if(isValid(row, col, n))

        for(int i = 0; i < 8; i++){
            int r_new = dr[i] + row;
            int c_new = dc[i] + col;

            if(isValid(r_new, c_new, n) &&  grid[r_new][c_new] == count+1){
                return fun(r_new, c_new, grid, count+1);
            }
        }
        return false;
    }
    

    public boolean checkValidGrid(int[][] grid) {
        return fun(0,0,grid, 0);
    }
}