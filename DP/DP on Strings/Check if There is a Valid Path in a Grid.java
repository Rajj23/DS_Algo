//Approach (Using DFS)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    Map<Integer, int[][]> dir = new HashMap<>();

    boolean isValid(int r, int c, int m, int n){
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    boolean dfs(int r, int c, int[][] grid, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;

        if(r == m-1 && c == n-1) return true;

        visited[r][c] = true;

        for(int[] d : dir.get(grid[r][c])){
            int new_r = r + d[0];
            int new_c = c + d[1];

            if(!isValid(new_r, new_c, m, n) || visited[new_r][new_c]) continue;

            for(int[] backD : dir.get(grid[new_r][new_c])){
                if(new_r + backD[0] == r &&
                    new_c + backD[1] == c
                ){
                  if(dfs(new_r, new_c, grid, visited)){
                    return true;
                  }  
                }
            }
        }

        return false;
    }

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dir.put(1, new int[][]{{0, -1}, {0, 1}});
        dir.put(2, new int[][]{{-1, 0}, {1, 0}});
        dir.put(3, new int[][]{{0, -1}, {1, 0}});
        dir.put(4, new int[][]{{0, 1}, {1, 0}});
        dir.put(5, new int[][]{{0, -1}, {-1, 0}});
        dir.put(6, new int[][]{{-1, 0}, {0, 1}});

        boolean[][] visited = new boolean[m][n];

        return dfs(0, 0, grid, visited);
    }
}