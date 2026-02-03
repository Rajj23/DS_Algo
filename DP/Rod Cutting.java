// T.C: O(n)
// S.C: O(n)
class Solution {
    int[] t;
    int solve(int idx, int[] price){
        if(idx == 0) return 0;
        
        if(t[idx] != -1) return t[idx];
        
        int n = price.length;
        
        int currMax = 0;
        for(int i = 1; i <= idx; i++){
            currMax = Math.max(currMax, price[i-1] + solve(idx - i, price));
        }
        
        return t[idx] = currMax;
    }
    
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        t = new int[n+1];
        
        Arrays.fill(t, -1);
        return solve(n, price);
         }
}