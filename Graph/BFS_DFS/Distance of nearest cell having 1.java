// T.C: O(E log E)
// S.C: O(E + V)
class Solution {
        
    int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int m;
    int n;
    
    boolean isValid(int r, int c){
        return r >= 0 && c >= 0 && r < m && c < n;
    }
    
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        
        m = grid.length;
        n = grid[0].length;
        
        int[][] adj = new int[m][n];
        
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    adj[i][j] = 0;
                    q.add(new int[]{i, j});
                }
                else{
                    adj[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int r = curr[0];
            int c = curr[1];
            
            for(int[] dir : direction){
                int r_  = r + dir[0];
                int c_ = c + dir[1];
                
                if(isValid(r_, c_) && adj[r_][c_] > adj[r][c] + 1){
                    adj[r_][c_] = adj[r][c]+1;
                    
                    q.add(new int[]{r_, c_});
                }
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < m ; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                list.add(adj[i][j]);
            }
            result.add(list);
        }
        
        return result;
    }
}