// T.C: O(nlog(n))
// S.C: O(1)
class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b)->{
            int diff1 = a[1] - a[0];
            int diff2 = b[1] - b[0];

            if(diff1 == diff2){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(diff2, diff1);
        });

        int curr = 0, req = 0;

        for(int i = 0; i < tasks.length; i++){
            if(tasks[i][1] > curr){
                req += tasks[i][1] - curr;
                curr = tasks[i][1];
            }
            curr -= tasks[i][0];
        }
        return req;
    }
}