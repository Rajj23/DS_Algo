// T.C: O(n*log(n))
// S.C: O(1)
class Solution {
    boolean possible(int[] weights, int cap, int days){
        int day = 1;
        int currCap = 0;

        for(int weight : weights){
            if(currCap + weight > cap){
                day++;
                currCap = weight;
            }
            else{
                currCap += weight;
            }
        }

        return day <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int weight : weights){
            low = Math.max(weight, low);
            high += weight;
        }
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(possible(weights, mid, days)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}