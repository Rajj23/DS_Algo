// T.C: O(n)
// S.C: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int n = prices.length;
        int buy = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            result = Math.max(result, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }

        return result;
    }
}