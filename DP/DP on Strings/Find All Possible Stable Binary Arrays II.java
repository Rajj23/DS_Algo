//Approach-1 (Bottom Up - Derived from Part-I)
//T.C : O(one * zero)
//S.C : O(one * zero)
class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int M = (int) 1e9 + 7;

        int[][][] t = new int[zero+1][one+1][2];

        for(int j = 1; j <= Math.min(limit, one); j++){
            t[0][j][1] = 1;
        }

        for(int i = 1; i <= Math.min(zero, limit); i++){
            t[i][0][0] = 1;
        }

        for(int i = 0; i <= zero; i++){
            for(int j = 0; j <= one; j++){

                if(i == 0 || j == 0) continue;

                t[i][j][1] = (t[i][j-1][0] + t[i][j-1][1]) % M;
                if(j-1 >= limit){
                    t[i][j][1] = (t[i][j][1] - t[i][j-1-limit][0] + M) % M;
                }
                 

                t[i][j][0] = (t[i-1][j][1] + t[i-1][j][0]) % M;
                if(i-1 >= limit){
                    t[i][j][0] = (t[i][j][0] - t[i-1-limit][j][1] + M) % M;
                }
            }
        }

        return (t[zero][one][0] + t[zero][one][1]) % M;
    }
}