// T.C: O(n)
// S.C: O(1)
class Solution {
    public long getDescentPeriods(int[] prices) {
        int prev = prices[0];
        int cont = 1;
        long result = 1;

        for(int i=1;i<prices.length;i++){
            if(prev-prices[i]==1){
                cont++;
            }
            else{
                cont = 1;
            }
            prev = prices[i];
            result += cont;
        }
        return result;
    }
}