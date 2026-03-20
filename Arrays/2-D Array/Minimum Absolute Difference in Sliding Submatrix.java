//Approach - Iterate and check all k*k matrices
//T.C : O(O((m−k)×(n−k)×k^2×logk)
//S.C : O(k^2
class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m-k+1][n-k+1];


        for(int i = 0; i < m-k+1; i++){
            for(int j = 0; j < n-k+1; j++){   
                TreeSet<Integer> set = new TreeSet<>();
                for(int row = i; row < i + k; row++){
                    for(int col = j; col < j + k; col++){
                        set.add(grid[row][col]);
                    }
                }
                int minDiff = Integer.MAX_VALUE;
                int prev = Integer.MIN_VALUE/2;
                for(int val : set){
                    if(prev != Integer.MIN_VALUE/2){
                        minDiff = Math.min(minDiff, val - prev);
                    }
                    prev = val;
                }
                result[i][j] = (minDiff != Integer.MAX_VALUE ? minDiff : 0);
            }
        }
        return result;
    }
}