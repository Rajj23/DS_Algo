// Approach: Memoization
// T.C: O(one * zero * limit)
// S.C: O(one * zero)
class Solution {
    int M = (int) 1e9 + 7;

    int[][][] t;

    int solve(int onesLeft, int zerosLeft, int lastWasOne, int limit){
        if(onesLeft == 0 && zerosLeft == 0){
            return 1;
        }
        
        if(t[onesLeft][zerosLeft][lastWasOne] != -1){
            return t[onesLeft][zerosLeft][lastWasOne];
        }

        int result = 0;

        if(lastWasOne == 1){
            for(int len = 1; len <= Math.min(zerosLeft, limit); len++){
                result = (result + solve(onesLeft, zerosLeft - len, 0, limit)) % M;
            }
        }
        else{
            for(int len = 1; len <= Math.min(onesLeft, limit); len++){
                result = (result + solve(onesLeft - len, zerosLeft, 1, limit)) % M;
            }
        }

        return t[onesLeft][zerosLeft][lastWasOne] = result;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        t = new int[201][201][2];
        for(int i = 0; i < 201; i++){
            for(int j = 0; j < 201; j++){
                Arrays.fill(t[i][j], -1);
            }
        }

        int startWithOne = solve(one, zero, 0, limit);
        int startWithZero = solve(one, zero, 1, limit);

        return (startWithOne + startWithZero) % M;
    }
}


// Approach: Bottum Up
// T.C: O(one * zero * limit)
// S.C: O(one * zero)

class Solution {

    public int numberOfStableArrays(int zero, int one, int limit) {
        int M = (int) 1e9 + 7;
        int[][][] t = new int[201][201][2];
        for(int i = 0; i < 201; i++){
                for(int j = 0; j < 201; j++){
                    Arrays.fill(t[i][j], -1);
                }
            }

        t[0][0][0] = 1;
        t[0][0][1] = 1;


        for(int onesLeft = 0; onesLeft <= one; onesLeft++){
            for(int zerosLeft = 0; zerosLeft <= zero; zerosLeft++){

                if(onesLeft == 0 && zerosLeft == 0) continue;

                int result = 0;

                for(int len = 1; len <= Math.min(zerosLeft, limit); len++){
                    result = (result + t[onesLeft][zerosLeft - len][0]) % M;
                }

                t[onesLeft][zerosLeft][1] = result;

                result = 0;
                for(int len = 1; len <= Math.min(onesLeft, limit); len++){
                    result = (result + t[onesLeft - len][zerosLeft][1]) % M;
                }

                t[onesLeft][zerosLeft][0] = result;
            }
        }

        
        int startWithOne = t[one][zero][0];
        int startWithZero = t[one][zero][1];

        return (startWithOne + startWithZero) % M;
    }
}