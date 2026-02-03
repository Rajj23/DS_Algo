// T.C: O(n)
// S.C: O(n)
class Solution {
    int[][] t;
    int solve(int W, int idx, int[] val, int[] wt){
        if(idx >= val.length || W == 0){
            return 0;
        }
        
        if(t[W][idx] != -1){
            return t[W][idx];
        }
        
        int x = solve(W, idx+1, val, wt);
        
        int y = 0;
        if(W >= wt[idx])
            y = val[idx] + solve(W-wt[idx], idx+1, val, wt);
        
        return t[W][idx] =  Math.max(x,y);
    }
    
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        t = new int[W+1][val.length];
        for(int i = 0; i <= W; i++){
            Arrays.fill(t[i], -1);
        }
        
        return solve(W, 0, val, wt);
    }
}


// T.C: O(n)
// S.C: O(n)
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] t = new int[n+1][W+1];
        
        for (int j = 0; j <= W; j++) {
            t[n][j] = 0;
        }
        
        
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j <= W; j++){
                int x = t[i+1][j];
                int y = 0;
                
                if(j >= wt[i])
                    y = t[i+1][j-wt[i]] + val[i];
                
                int max = Math.max(x,y);
                t[i][j] = max;
            }
        }
        
        return t[0][W];
    }
}