// T.C: O(V+E)
// S.C: O(V)
class Solution {
    boolean isValid(int r, int c, int n, int m){
        return r >= 0 && r < n && c >= 0 && c < m;
    }
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new ArrayDeque<>();

        int[][] mat = new int[n][m];
        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(vis[i], -1);
        }

        for(int i = 0; i < sources.length; i++){
            int r = sources[i][0];
            int c = sources[i][1];
            int col = sources[i][2];

            mat[r][c] = col;
            vis[r][c] = 0;
            q.add(new int[]{r, c, col, 0});
        }

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int row = temp[0];
            int col = temp[1];
            int c = temp[2];
            int time = temp[3];

        
            mat[row][col] = c;

            for(int i = 0; i < 4; i++){
                int row_ = row + dir[i][0];
                int col_ = col + dir[i][1];
                if(isValid(row_, col_, n, m)){
                    int time_ = time+1;

                    if(vis[row_][col_] == -1){
                        mat[row_][col_] = c;
                        q.add(new int[]{row_, col_, c, time_});
                        vis[row_][col_] = time_;
                    }
                    else if(vis[row_][col_] == time_){
                        if(c > mat[row_][col_]){
                            mat[row_][col_] = c;
                            q.add(new int[]{row_, col_, c, time_});
                        }
                    }
                    
                }
            }
        }

        return mat;
    }
}