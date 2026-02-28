// T.C: O(n)
// S.C: O(n)
class Solution {
    final int MOD = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long result = 0;

        for(int i = 1; i <= n; i++){
            int bits = (int)(Math.log(i) / Math.log(2)) + 1;
            result = ((result << bits) % MOD + i) % MOD;
        }

        return (int) result;
    }
}


// T.C: O(n)
// S.C: O(n)
class Solution {
    final int MOD = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long result = 0;
        int bits = 0;

        for(int i = 1; i <= n; i++){
            if(Integer.bitCount(i) == 1) bits++;
            result = ((result << bits) % MOD + i) % MOD;
        }

        return (int) result;
    }
}