// Approach : Memoization
// T.C : O(n)
// S.C : O(n)
class Solution {
    int[] t;
    int solve(int idx, int[] height){
        
        if(idx == height.length - 1) return 0;
        
        if (idx >= height.length) return Integer.MAX_VALUE;
        
        if(t[idx] != -1) return t[idx];

        
        int curr = Integer.MAX_VALUE;
        
        int x = Math.abs(height[idx] - height[idx+1]) + solve(idx+1, height);
        
        int y = Integer.MAX_VALUE;
        if(idx+2 < height.length){
            
            y = Math.abs(height[idx] - height[idx+2]) + solve(idx + 2, height);
        }
        
        return t[idx] = Math.min(x,y);
    }
    int minCost(int[] height) {
        // code here
        t = new int[height.length];
        Arrays.fill(t, -1);
        return solve(0, height);
    }
}