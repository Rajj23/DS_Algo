// T.C: O(2n + nlogn)
// S.C: O(2n)
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        int[][] combineTime = new int[n][2];
        
        for(int i=0;i<n;i++){
            combineTime[i][0] = start[i];
            combineTime[i][1] = end[i];
        }
        
        Arrays.sort(combineTime,(a,b)->{
            if(b[1]==a[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        
        int result = 0;
        int occupied = -1;
        
        for(int i=0;i<n;i++){
            int startM = combineTime[i][0];
            int endM = combineTime[i][1];
            
            if(occupied>=startM) continue;
            
            occupied = endM;
            result++;
        }
        return result;
    }
}
