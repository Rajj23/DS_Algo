//Approach-1 (Recursion + Memoization) - TLE
//T.C : O(n*m*m), we have n*m*2 states and we run for loop inside the recursion
//S.C : O(n*m)
class Solution {
    int N, M;
    int MOD = (int) 1e9 + 7;

    int[][][] t;

    int solve(int i, int prevVal, int increasing){
        if(i == N) return 1;

        if(t[i][prevVal][increasing] != -1) return t[i][prevVal][increasing];
        
        long result = 0;

        if(increasing == 1){
            for(int nextVal = prevVal+1; nextVal <= M; nextVal++){
                result = (result + solve(i+1, nextVal, 0)) % MOD;
            }
        }
        else{
            for(int nextVal = 1; nextVal < prevVal; nextVal++){
                result = (result + solve(i+1, nextVal, 1)) % MOD;
            }
        }

        return t[i][prevVal][increasing] = (int) result;
    }

    public int zigZagArrays(int n, int l, int r) {
        N = n;
        M = r - l + 1;

        t = new int[2001][2001][2];
        for(int i = 0; i < 2001; i++){
            for(int j = 0; j < 2001; j++)
                Arrays.fill(t[i][j], -1);
        }
      
        long result = 0;

        for(int startVal = 1 ; startVal <= M; startVal++){

            result = (result + solve(1, startVal, 1)) % MOD;

            result = (result + solve(1, startVal, 0)) % MOD;

        }

        return (int) result;
    }
}

//Approach-2 (Bottom Up) - TLE
//T.C : O(n*m*m), we have n*m*2 states and we run for loop inside the recursion
//S.C : O(n*m)
class Solution {
    int MOD = (int) 1e9+7;

    public int zigZagArrays(int n, int l, int r) {
        int N = n;
        int M = r - l + 1;

        long[][][] t = new long[2001][2001][2];

        for(int prevVal = 1; prevVal <= M; prevVal++){
            t[N][prevVal][1] = 1;
            t[N][prevVal][0] = 1;
        }

        for(int i = N-1; i >= 0; i--){
            for(int prevVal = 1; prevVal <= M; prevVal++){

                for(int nextVal = prevVal+1; nextVal <= M; nextVal++){
                    t[i][prevVal][1] = (t[i][prevVal][1] + t[i+1][nextVal][0]) % MOD;
                }

                for(int nextVal = 1; nextVal < prevVal; nextVal++){
                    t[i][prevVal][0] = (t[i][prevVal][0] + t[i+1][nextVal][1]) % MOD;
                }
            }
        }
        long result = 0;
        for(int startVal = 1; startVal <= M; startVal++){
            result = (result + t[1][startVal][1]) % MOD;

            result = (result + t[1][startVal][0]) % MOD;
        }
        return (int)result;
    }
}

//Approach-3 (Bottom Up + Prefix Sum) 
//T.C : O(n*m)
//S.C : O(n*m)
class Solution {
    int MOD = (int) 1e9+7;

    public int zigZagArrays(int n, int l, int r) {
        int N = n;
        int M = r - l + 1;

        long[][][] t = new long[N+1][M+1][2];

        for(int prevVal = 1; prevVal <= M; prevVal++){
            t[N][prevVal][1] = 1;
            t[N][prevVal][0] = 1;
        }

        for(int i = N-1; i >= 0; i--){
            long[] cumSum1 = new long[M+1];
            long[] cumSum0 = new long[M+1];

            for(int val = 1; val <= M; val++){
                cumSum0[val] = (cumSum0[val-1] + t[i+1][val][0]) % MOD;
                cumSum1[val] = (cumSum1[val-1] + t[i+1][val][1]) % MOD;
                
            }

            for(int prevVal = 1; prevVal <= M; prevVal++){
                t[i][prevVal][1] = (cumSum0[M] - cumSum0[prevVal] + MOD) % MOD;
              
                t[i][prevVal][0] = (cumSum1[prevVal-1]);
            }
        }
        long result = 0;
        for(int startVal = 1; startVal <= M; startVal++){
            result = (result + t[1][startVal][1]) % MOD;

            result = (result + t[1][startVal][0]) % MOD;
        }
        return (int)result;
    }
}