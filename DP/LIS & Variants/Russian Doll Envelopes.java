class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        int n = envelopes.length;

        int ans = 1;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        ans = Math.max(dp[i], ans);
                    }
                }
            }
        }

        return ans;
    }
}