// T.C: O(nlogn + n)
// S.C: O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        int result = 0;
        int prevEnd = intervals[0][0];
        for(int[] interval : intervals){
            if(interval[0]<prevEnd){
                result++;
            }
            else{
                prevEnd = interval[1];
            }
        }

        return result;
    }
}