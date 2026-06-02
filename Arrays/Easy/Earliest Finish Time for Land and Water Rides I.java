// T.C: O(n*m)
// S.C: O(1)
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int result = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        for(int i = 0; i < n; i++){
            int landTime = landStartTime[i] + landDuration[i];
            for(int j = 0; j < m; j++){
                int sum1 = 0;

                int waterTime = waterStartTime[j] + waterDuration[j];

                int finish1 = Math.max(landTime, waterStartTime[j]) + waterDuration[j];
                int finish2 = Math.max(waterTime, landStartTime[i]) + landDuration[i];

                result = Math.min(result, Math.min(finish1, finish2));
            }
        }

        return result;
    }
}