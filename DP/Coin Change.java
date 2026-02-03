// T.C: O(n)
// S.C: O(n)
class Solution {
    int[][] t;
    int solve(int idx, int[] coins, int amount){
        if(amount == 0) return 0;

        if(idx >= coins.length) return Integer.MAX_VALUE;

        if(t[idx][amount] != -1) return t[idx][amount];

        int notPick = solve(idx+1, coins, amount);
        
        int pick = Integer.MAX_VALUE;
        if(amount >= coins[idx]){
            int curr = solve(idx, coins, amount - coins[idx]);
            if(curr != Integer.MAX_VALUE) {
                pick = 1 + curr;
            }
        }
        int minComb = Math.min(pick, notPick);

        return t[idx][amount] = minComb;
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        t = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(t[i], -1);
        }
        int result = solve(0, coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result
;    }
}