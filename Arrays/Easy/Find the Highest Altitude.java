// T.C: O(n)
// S.C: O(1)
class Solution {
    public int largestAltitude(int[] gain) {
        int height = 0;
        int ans = 0;

        for(int altitude : gain){
            height += altitude;

            ans = Math.max(ans, height);
        }

        return ans;
    }
}