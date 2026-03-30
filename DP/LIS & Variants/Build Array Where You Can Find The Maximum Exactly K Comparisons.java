//Approach-1 (Using Recursion + Memoization)
//T.C : O(m*n*k)
class Solution {
    int N, M, K;
    int MOD = (int) 1e9+7;
    int[][][] t;

    int solve(int idx, int searchCost, int maxSoFar){
        if(idx == N){
            if(searchCost == K){
                return 1;
            }
            return 0;
        }

        if(t[idx][searchCost][maxSoFar] != -1) return t[idx][searchCost][maxSoFar];

        int result = 0;

        for(int i = 1; i <= M; i++){
            if(i > maxSoFar){
                result = (result + solve(idx+1, searchCost+1, i)) % MOD;
            }
            else{
                result = (result + solve(idx+1, searchCost, maxSoFar)) % MOD;
            }
        }

        return t[idx][searchCost][maxSoFar] = (result % MOD);
    }

    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;

        t = new int[n+1][n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                Arrays.fill(t[i][j], -1);
            }
        }

        return solve(0, 0, 0);
    }
}