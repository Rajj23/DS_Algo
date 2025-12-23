// T.C: O(nlog + 2n)
// S.C: O(2n)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n = intervals.length;
        int prev = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1;i<n;i++){
            if(intervals[i][0] > prev){
                list.add(intervals[i]);
                prev = intervals[i][1];
            }
            else{
                int[] temp = list.get(list.size()-1);
                temp[1] = Math.max(temp[1], intervals[i][1]);
                prev = temp[1];
            }
        }
        int m = list.size();
        int[][] result = new int[m][2];

        for(int i=0;i<m;i++){
            result[i] = list.get(i);
        }

        return result;
    }
}