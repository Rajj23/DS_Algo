// T.C : O(n*log*n)
// S.C : O(1);
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a,b)->{
            if(a[1] != b[1])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        int result = 0;
        int first = -1;
        int second = -1;

        for(int i=0;i<n;i++){
            int l = intervals[i][0];
            int r = intervals[i][1];

            if(l<=first){
                continue;
            }
            if(l>second){
                result+=2;
                second = r;
                first = r-1;
            }   
            else{
                result+=1;
                first = second;
                second = r;
            }
        }
        return result;
    }
}