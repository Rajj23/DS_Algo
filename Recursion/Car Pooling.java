// Approach: Difference array / prefix sum on locations.
// Find the maximum location, build an array `drop` where for each trip
// we add passengers at `from` and subtract them at `to`. Then run a
// prefix sum over `drop` to simulate the car's occupancy along the
// route and check it never exceeds capacity.
//
// Time Complexity: O(n + M), where n is number of trips and
//   M is the maximum location value.
// Space Complexity: O(M) for the difference/prefix array.
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, trips[i][2]);
        }

        int[] drop = new int[max+1];

        
        for(int i = 0; i < n; i++){
            int pass = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            drop[from] += pass;
            drop[to] -= pass;
        }


        int currCap = 0;
        for(int i = 0; i <= max; i++){
            currCap += drop[i];
            if(currCap > capacity) return false;
        }

        return true;
    }
}