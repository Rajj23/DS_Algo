// Memoization
// T.C: O(n)
// S.C: O(n)
class Solution {
    int[][] t;
    int solve(int idx, int buyed, int[] prices){
        if(idx == prices.length) return t[idx][buyed] = 0;

        if(t[idx][buyed] != -1) return t[idx][buyed];

        if(buyed == 1){
            int take = solve(idx+1, 0, prices) - prices[idx];
            int notTake = solve(idx+1, 1, prices);

            return t[idx][buyed] = Math.max(take, notTake);
        }
        else{
            int buy = solve(idx+1, 1, prices) + prices[idx];
            int notBuy = solve(idx+1, 0, prices);

            return t[idx][buyed] = Math.max(buy, notBuy);
        }

    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        t = new int[n+1][2];
        for(int i = 0; i <= n; i++){
            Arrays.fill(t[i], -1);
        }

        return solve(0, 1, prices);       
    }
}


// Approach: Tabulization
// T.C: O(n)
// S.C: O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] t = new int[n + 1][2];

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buyed = 0; buyed < 2; buyed++) {
                if (buyed == 1) {
                    int take = t[idx+1][0] - prices[idx];
                    int notTake = t[idx+1][1];

                    t[idx][buyed] = Math.max(take, notTake);
                } else {
                    int buy = t[idx+1][1] + prices[idx];
                    int notBuy = t[idx+1][0];

                    t[idx][buyed] = Math.max(buy, notBuy);
                }
            }
        }

        return t[0][1];
    }
}