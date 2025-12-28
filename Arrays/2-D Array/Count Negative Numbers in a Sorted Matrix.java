// Approach 1
// T.C: O(n*m)
// S.C: O(1)
class Solution {
    public int countNegatives(int[][] grids) {
        int count = 0;
        int m = grids.length;
        int n = grids[0].length;

        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(grids[i][j]<0){
                    count++;
                }
                else{
                    break;
                }
            }
        }

        return count;
    }
}


// Approach 2
// T.C: O(mlogn)
// S.C: O(1)
class Solution {
    private int upperBound(int[] row){
        int n = row.length;
        int result = -1;

        int l=0,h=n-1;
        
        while(l<=h){
            int mid = l+(h-l)/2;

            if(row[mid]<0){
                h = mid-1;
                result = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return result == n ? -1 : result;
    }
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;

        for(int[] row : grid){

            int idx = upperBound(row);

            if(idx!=-1)    
                result += (n-idx);

        }

        return result;
    }
}

// Approach 3
// T.C: O(n+m)
// S.C: O(1)
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int row = m-1;
        int col = 0;

        int result = 0;

        while(row>=0 && col<n){
            if(grid[row][col] >=0){
                col++;
            }
            else{
                result += (n-col);
                row--;
            }
        }

        return result;
    }
}