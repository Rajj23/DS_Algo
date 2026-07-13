// T.C: O(max(m,n))
// S.C: O(3m)
class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = queries.length;
        int m = s.length();
        int MOD = (int) 1e9 + 7;

        int[] result = new int[n];

        long[] prefixMod = new long[m];
        int[] cnt = new int[m];
        int[] sumArr = new int[m];

        long currMod = 0;
        int currCnt = 0;
        int currSum = 0;

        for(int i = 0; i < m; i++){
            char ch = s.charAt(i);

            if(ch != '0'){
                int d = ch - '0';
                currMod = (currMod * 10 + d) % MOD; 
                currSum += d;
                currCnt++;
            }

            prefixMod[i] = currMod;
            cnt[i] = currCnt;
            sumArr[i] = currSum;
        }

        long[] pow10 = new long[m+1];
        pow10[0] = 1;
        for(int i = 1; i <= m; i++){
            pow10[i] = (pow10[i-1] * 10) % MOD;
        }

        for(int i = 0; i < n; i++){
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];

            long xVal;
            int sum;

            if(start == 0){
                xVal = prefixMod[end];
                sum = sumArr[end];
            }
            else{
                int shift = cnt[end] - cnt[start - 1];
                xVal = (prefixMod[end] - prefixMod[start-1] * pow10[shift]) % MOD;
                if(xVal < 0) xVal += MOD;
                sum = sumArr[end] - sumArr[start-1];
            }

            long ans = (xVal * sum) % MOD;
            result[i] = (int) ans;
        }

        return result;
    }
}