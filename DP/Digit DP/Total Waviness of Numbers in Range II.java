//Approach-1 (Digit DP - Counting waviness contribution per position)
//T.C : O(n * 10 * 10 * 10) where n = number of digits ~ O(1) since n <= 15
//S.C : O(n * 10 * 10) for memoization
class Solution {
    String s;
    int n;

    long[][][] dpTotalNumbers;
    long[][][] dpTotalWaviness;

    long[] solve(int curr, int prevPrev, int prev, boolean isLimitedWithActualNumber, boolean isLeadingZero){
        if(curr == n) return new long[]{1, 0};

        if(!isLimitedWithActualNumber && !isLeadingZero && prevPrev >= 0 && prev >= 0){
            if(dpTotalNumbers[curr][prevPrev][prev] != -1 && dpTotalWaviness[curr][prevPrev][prev] != -1){
                return new long[]{dpTotalNumbers[curr][prevPrev][prev], dpTotalWaviness[curr][prevPrev][prev]};
            }
        }

        long totalNumbers = 0;
        long totalWaveScore = 0;

        int limitDigit = isLimitedWithActualNumber ? s.charAt(curr) - '0' : 9;

        for(int digit = 0; digit <= limitDigit; digit++){
            boolean newIsLeadingZero = isLeadingZero && (digit == 0);

            int newPrevPrev = prev;
            int newPrev = newIsLeadingZero ? -1 : digit;

            long[] result = solve(curr+1, newPrevPrev, newPrev, isLimitedWithActualNumber && (digit == limitDigit),
            newIsLeadingZero);

            if(!newIsLeadingZero && prevPrev >= 0 && prev >= 0){
                boolean isPeak = (prevPrev < prev && prev > digit);
                boolean isValley = (prevPrev > prev && prev < digit);

                if(isPeak || isValley){
                    totalWaveScore += result[0];
                }
            }

            totalNumbers += result[0];
            totalWaveScore += result[1];
        }

        if(!isLimitedWithActualNumber && !isLeadingZero && prevPrev >= 0 && prev >= 0){
            dpTotalNumbers[curr][prevPrev][prev] = totalNumbers;
            dpTotalWaviness[curr][prevPrev][prev] = totalWaveScore;
        }

        return new long[] {totalNumbers, totalWaveScore};
    }

    long func(long num){
        if(num < 100){
            return 0;
        }

        s = String.valueOf(num);
        n = s.length();

        dpTotalNumbers = new long[16][10][10];
        dpTotalWaviness = new long[16][10][10];

        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 10; j++){
                Arrays.fill(dpTotalNumbers[i][j], -1);
                Arrays.fill(dpTotalWaviness[i][j], -1);
            }
        }

        long[] result = solve(0, -1, -1, true, true);

        return result[1];

    }

    public long totalWaviness(long num1, long num2) {

        return func(num2) - func(num1 - 1);
    }
}