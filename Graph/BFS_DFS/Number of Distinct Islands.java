// T.C: O(V + E)
// S.C: O(V*V)
class Solution {
    Set<String> st;
    
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int n;
    int m;
    
    boolean isValid(int r, int c){
        return r >= 0 && c >= 0 && r < m && c < n;
    }
    
    void bfs(int r, int c, int[][] grid, boolean[][] visited) {
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;
        
        StringBuilder sb = new StringBuilder();
        sb.append("0_0#");
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int x = curr[0];
            int y = curr[1];
            
            for(int[] dir : direction){
                int x_ = x + dir[0];
                int y_ = y + dir[1];
                
                if(isValid(x_, y_) && !visited[x_][y_] && grid[x_][y_] == 1){
                    int dist_x = x_ - r;
                    int dist_y = y_ - c;
                    visited[x_][y_] = true;
                    
                    sb.append(dist_x + "_"+ dist_y + "#");
                    q.add(new int[]{x_, y_});
                }
            }
            
        }
        
        st.add(sb.toString());
        
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        st = new HashSet<>();
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    bfs(i, j, grid, visited);
                }
            }
        }
        
        return st.size();
    }
}
