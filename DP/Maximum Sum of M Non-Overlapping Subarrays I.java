// T.C: O(m*n)
// S.C: O(m*n)
class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        int n = nums.length;
        Long min = Long.MIN_VALUE/2;

        long[] prefix = new long[n+1];
        for(int i = 0; i < n; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        long[][] t = new long[m+1][n+1];
        for(int i = 0; i <= m; i++){
            Arrays.fill(t[i], Long.MIN_VALUE/2);
        }
        t[0][0] = 0;

        for(int j = 1; j <= n; j++){
            t[0][j] = 0;
        }

        for(int k = 1; k <= m; k++){
            Deque<Integer> dq = new ArrayDeque<>();

            for(int j = 0; j <= n; j++){

                if(j > 0 && t[k][j-1] != min){
                    t[k][j] = Math.max(t[k][j], t[k][j-1]);
                }
                
                int idx = j - l;

                if(idx >= 0 && t[k-1][idx] != Long.MIN_VALUE/2){
                    long sum = t[k-1][idx] - prefix[idx];
                    while(!dq.isEmpty() && t[k-1][dq.peekLast()] - prefix[dq.peekLast()] < sum){
                        dq.pollLast(); 
                    }
                    dq.addLast(idx);
                }

                while(!dq.isEmpty() && dq.peekFirst() < j - r){
                    dq.pollFirst();
                }

                if(!dq.isEmpty()){
                    long window = t[k-1][dq.peekFirst()] - prefix[dq.peekFirst()];
                    t[k][j] = Math.max(t[k][j], prefix[j] + window);
                }
            }
        }

        long ans = min;
        for(int k = 1; k <= m; k++){
            if(t[k][n] != min){
                ans = Math.max(ans, t[k][n]);
            }
        }

        return ans;
    }
}