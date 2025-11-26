// Approach 1
// T.C : O(m*n*k)
// S.C : O(m*n*k)
class Solution {
    Integer[][][] t; 
    int MOD = 1_000_000_007;
    int solve(int[][] grid,int r,int c,int k,int currSum){
        int n = grid.length, m = grid[0].length;
        if(r>=n || c>=m) 
            return 0;

        if(r==n-1 && c==m-1){
            return (currSum+grid[r][c])%k==0 ? 1 : 0;
        }

        if(t[r][c][currSum]!=null){
            return t[r][c][currSum];
        }
       
        int down = solve(grid,r+1,c,k,(currSum+grid[r][c])%k);

        int right = solve(grid,r,c+1,k,(currSum+grid[r][c])%k);

        t[r][c][currSum] = (down+right)%MOD;
        return  t[r][c][currSum];
    }
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        t = new Integer[m][n][k];
        return solve(grid,0,0,k,0);
    }
}

// Approach 2
// T.C : O(m*n*k)
// S.C : O(m*n*k)
class Solution {
    int MOD = 1_000_000_007;
    public int numberOfPaths(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;

        int[][][] t = new int[m+1][n+1][k+1];
        
        for(int remain = 0;remain <=k-1;remain++){
            t[m-1][n-1][remain] = (remain + grid[m-1][n-1]) % k==0 ? 1 : 0;
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){

                for(int remain=0;remain<=k-1;remain++){
                    if(i==m-1 && j==n-1)
                        continue;

                    int R = (remain + grid[i][j])%k;

                    int down = t[i+1][j][R];
                    int right = t[i][j+1][R];

                    t[i][j][remain] = (down+right)%MOD;
                }
            }
        }
        return t[0][0][0];
    }
}