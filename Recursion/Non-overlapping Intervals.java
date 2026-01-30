// Approach: Greedy interval scheduling on end times.
// Sort all intervals by increasing end time (and then by start time
// to break ties). Traverse in this order, always keeping the last
// selected interval's end; when the next interval overlaps (its start
// is < last end), increment the removal count, otherwise accept it and
// update the last end.
//
// Time Complexity: O(n log n) for sorting n intervals.
// Space Complexity: O(1) extra (sorting is in-place aside from call stack).
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        
        Arrays.sort(intervals, (a,b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int prev = intervals[0][1];
        int count = 0;

        for(int i = 1; i < n; i++){
            if(prev > intervals[i][0]){
                count++;
                continue;
            }
            prev = intervals[i][1];
        }

        return count;
    }
}