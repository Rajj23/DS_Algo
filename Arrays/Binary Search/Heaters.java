// T.C: O(log(n))
// S.C: O(1)
class Solution {
    int lowerBound(int[] heaters,int house){
        int low = 0;
        int high = heaters.length - 1;
        int ans = heaters.length;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(heaters[mid] >= house){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int maxRadius = 0;

        for(int house : houses){
            int right = lowerBound(heaters, house);
            int left = right - 1;

            int rightRadius = (right < heaters.length) ? heaters[right] - house : Integer.MAX_VALUE;
            int leftRadius = (left >= 0) ? house - heaters[left] : Integer.MAX_VALUE;

            int minRadius = Math.min(rightRadius, leftRadius);

            maxRadius = Math.max(maxRadius, minRadius);
        }

        return maxRadius;
    }
}