// T.C: O(nlogn)
// S.C: O(1)
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);

        int cnt = 0;
        for(int cost: costs){
            if(cost > coins) return cnt;

            coins -= cost;
            cnt++;
        }
        return cnt;
    }
}