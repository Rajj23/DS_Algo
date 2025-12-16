// T.C: O(n+m)
// S.C: O(2m)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int i=0;

        while(i<n && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        while(i<n){
            list.add(intervals[i]);
            i++;
        }

        int m = list.size();
        int[][] result = new int[m][2];

        for(int j=0;j<m;j++){
            result[j] = list.get(j);
        }

        return result;
    }
}