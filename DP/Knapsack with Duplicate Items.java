// Approach: Memoization
// T.C: O(n)
// S.C: O(2n)
class Solution {
    int[][] t;
    
    int solve(int idx, int[] val, int[] wt, int capacity){
        if(capacity == 0) return t[idx][capacity] = 0;
        
        if(idx >= val.length) return t[idx][capacity] = 0;
        
        if(t[idx][capacity] != -1) return t[idx][capacity];
        
        int x = 0;
        if(wt[idx] <= capacity){
            x = val[idx] + solve(idx, val, wt, capacity-wt[idx]);
        }
        
        int y = solve(idx+1, val, wt, capacity);
        
        return t[idx][capacity] = Math.max(x,y);
        
    }
    
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        t = new int[n+1][capacity+1];
        
        for(int i = 0; i <= n; i++){
            Arrays.fill(t[i], -1);
        }
        
        return solve(0, val, wt, capacity);
    }
}


// Approach: Tabulization
// T.C: O(n)
// S.C: O(2n)
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        
        int[][] t = new int[n+1][capacity+1];
        
        t[n-1][capacity] = 0;
        
        for(int i = n-1; i >= 0; i--){
            for(int cap = 0; cap <= capacity; cap++){
                int take = 0;
                
                if(cap>= wt[i])
                    take = val[i] + t[i][cap - wt[i]];
                
                int notTake = t[i+1][cap];
                
                t[i][cap] = Math.max(take, notTake);
            }
        }
        
        return t[0][capacity];
    }
}



