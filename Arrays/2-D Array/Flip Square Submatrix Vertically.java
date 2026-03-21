//Approach 1 - (Simulation)
//T.C : O(k^2)
//S.C : O(1)
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        for(int i = x; i < x + k/2; i++){
            for(int j = y; j < y + k; j++){
                int temp = grid[i][j];
                grid[i][j] = grid[2*x + k - 1 - i][j];
                grid[2*x + k - 1 - i][j] = temp;
            }
        }

        return grid;
    }
}

//Approach 2 - (Simulation)
//T.C : O(k^2)
//S.C : O(1)
class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int end = x + k - 1;

        for(int start = x; start < end; start++){
            for(int j = y; j < y + k; j++){
                int temp = grid[start][j];
                grid[start][j] = grid[end][j];
                grid[end][j] = temp;
            }
            end--;
        }
        return grid;
    }
}