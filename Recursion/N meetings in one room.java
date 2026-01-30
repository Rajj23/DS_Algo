// Approach: Greedy interval scheduling.
// Build (start, end) pairs for all meetings and sort them by
// increasing end time (and then by start time to break ties).
// Always pick the meeting that finishes earliest and is compatible
// with the last selected one (its start time is strictly greater
// than the end time of the last chosen meeting).
//
// Time Complexity: O(n log n) due to sorting n meetings.
// Space Complexity: O(n) for the auxiliary array of meeting pairs.
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        
        int n = start.length;
        int[][] pair = new int[n][2];
        
        for(int i = 0; i < n; i++){
            pair[i][0] = start[i];
            pair[i][1] = end[i];
        }
        
        Arrays.sort(pair, (a,b) ->{
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int last = pair[0][1];
        int count = 1;
        for(int i = 1; i < n; i++){
            if(last < pair[i][0]){
                count++;
                last = pair[i][1];
            }
        }
        
        return count;
    }
}
