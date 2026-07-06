// T.C: O(n log(n))
// S.C: O(1)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)->{
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int cnt = 0;

        int a = intervals[0][0];
        int b = intervals[0][1];

        for(int i = 1; i < n; i++){
            int c = intervals[i][0];
            int d = intervals[i][1];

            if(c >= a && b >= d){
                cnt++;
            }else{
                a = c;
                b = d;
            }
            
        }

        return n - cnt;
    }
}