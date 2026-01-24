// T.C: O(n*log(n))
// S.C: O(1)
class Solution {
    boolean possibleSpeed(int[] piles, int speed, int h){
        long totalHr = 0;

        for(int pile : piles){
            totalHr += (pile/speed);
            if(pile % speed != 0) totalHr++;
        }

        return totalHr <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for(int pile : piles){
            high = Math.max(pile, high);
        }  
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(possibleSpeed(piles, mid, h)){
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