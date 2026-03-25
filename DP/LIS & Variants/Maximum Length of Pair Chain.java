// Approach 1: rec + memo
// T.C: O(n*n)
// S.C: O(n*n)
class Solution {
    int[][] t;
    int solve(int idx, int prev, int[][] pairs){
        int n = pairs.length;
        if(idx >= n){
            return 0;
        }

        if(t[idx][prev] != -1) return t[idx][prev];

        int take = 0;
        if(prev == n || pairs[prev][1] < pairs[idx][0]){
            take = 1+solve(idx+1, idx, pairs);
        }

        int skip = solve(idx+1, prev, pairs);

        return t[idx][prev] = Math.max(take, skip);
    }

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        t = new int[n][n+1];
        for(int i = 0 ; i < n; i++){
            Arrays.fill(t[i], -1);
        }

        Arrays.sort(pairs, (a,b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        return solve(0, n, pairs);
    }
}


// Approach 2: bottom-up
// T.C: O(n*n)
// S.C: O(n)
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] t = new int[n];
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        Arrays.fill(t, 1);

        int result = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    t[i] = Math.max(t[i], t[j] + 1);
                }
            }
            result = Math.max(result, t[i]);
        }

        return result;
    }
}