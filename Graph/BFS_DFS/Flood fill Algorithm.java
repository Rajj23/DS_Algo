// T.C: O(V+E)
// S.C: O(2V)
class Solution {
    int[][] direction = {{-1,0}, {1,0}, {0, 1}, {0, -1}};
    
    int m;
    int n;
    
    boolean isValid(int r, int c){
        return r >= 0 && c >= 0 && r < m && c < n;
    }
    
    void dfs(int[][] image, int sr, int sc, int oldCol, int newCol){
        if(image[sr][sc] != oldCol) return;
        
        image[sr][sc] = newCol;
        
        for(int[] dir : direction){
            int sr_ = sr + dir[0];
            int sc_ = sc + dir[1];
            
            if(isValid(sr_, sc_) && image[sr_][sc_] == oldCol){
                dfs(image, sr_, sc_, oldCol, newCol);
            }
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
        m = image.length;
        n = image[0].length;
        
        int oldCol = image[sr][sc];
        
        if(oldCol == newColor) return image;
        
        dfs(image, sr, sc, oldCol, newColor);
        
        return image;
    }
}
