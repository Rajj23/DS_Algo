//Approach-1 (Recursion + Memoization)
//T.C : O(n * k)
//S.C : O(n * k)
class Solution {
    long[][][] t;

    long solve(int i,int k,int CASE,int[] prices){
        if(i==prices.length){
            if(CASE==0){
                return 0;
            }
            return Long.MIN_VALUE/2;
        }
        if(t[i][k][CASE]!=Long.MIN_VALUE){
            return t[i][k][CASE];
        }

        long take = Long.MIN_VALUE;
        long dontTake = 0;

        dontTake = solve(i+1,k,CASE,prices);

        if(k>0){
            if(CASE==1){
                take = prices[i] + solve(i+1,k-1,0,prices);
            }
            else if(CASE==2){
                take = -prices[i] + solve(i+1,k-1,0,prices);
            }
            else{
                take = Math.max(
                    -prices[i] + solve(i+1,k,1,prices),
                    prices[i] + solve(i+1,k,2,prices)
                );
            }
        }

        return t[i][k][CASE] = Math.max(take,dontTake);
    }
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        t = new long[n][k+1][3];

        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                for(int l=0;l<3;l++){
                    t[i][j][l] = Long.MIN_VALUE;
                }
            }
        }

        return solve(0,k,0,prices);
    }
}

//Approach-2 (Bottom Up)
//T.C : O(n * k)
//S.C : O(n * k)
class Solution {
    public long maximumProfit(int[] prices, int K){
        int n = prices.length;
        long[][][] t = new long[n+1][K+1][3];

        for(int k=0;k<=K;k++){
            t[n][k][0] = 0;
            t[n][k][1] = Long.MIN_VALUE/2;
            t[n][k][2] = Long.MIN_VALUE/2;
        }

        for(int i=n-1;i>=0;i--){
            for(int k=0;k<=K;k++){

                t[i][k][0] = t[i+1][k][0];

                if(k>0){
                    t[i][k][0] = Math.max(
                        t[i][k][0],
                        Math.max(
                            -prices[i] + t[i+1][k][1],
                            prices[i] + t[i+1][k][2]
                        )
                    );
                }

                t[i][k][1] = t[i+1][k][1];
                if(k>0){
                    t[i][k][1] = Math.max(
                        t[i][k][1],
                        prices[i] + t[i+1][k-1][0]
                    );
                }

                t[i][k][2] = t[i+1][k][2];
                if(k>0){
                    t[i][k][2] = Math.max(
                        t[i][k][2],
                        -prices[i] + t[i+1][k-1][0]
                    );
                }
            }
        }

        return t[0][K][0];
    }
}