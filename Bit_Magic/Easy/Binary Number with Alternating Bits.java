// T.C: O(log(n))
// S.C: O(1)
class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = -1;

        while(n != 0){
            int bit = n % 2;
            if(prev == bit) return false;

            prev = bit;
            n = n >> 1;
        }

        return true;
    }
}


// T.C: O(1)
// S.C: O(1)
class Solution {
    public boolean hasAlternatingBits(int n) {
        long result = n ^ (n >> 1);

        return (result & (result+1)) == 0;
    }
}