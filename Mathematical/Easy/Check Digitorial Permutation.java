// T.C: O(n)
// S.C: O(2n)
class Solution {
    long[] t;
    void fact(int num){
        t[0] = 1;

        for(int i = 1; i <= num; i++){
            t[i] = i* t[i-1];
        }
    }
    public boolean isDigitorialPermutation(int n) {
        t = new long[10];

        long sum = 0;
        long original = (long) n;
        
        while(n != 0){
            int digit = n%10;
            fact(digit);
            sum += t[digit];

            n /= 10;
        }

        int[] sumFreq = new int[10];
        int[] origFreq = new int[10];

        while(sum != 0){
            int dig = (int) sum % 10;
            sumFreq[dig]++;

            sum /= 10;
        }

        while(original != 0){
            int dig = (int) original % 10;
            origFreq[dig]++;

            original /= 10;
        }

        for(int i = 0; i < 10; i++){
            if(sumFreq[i] != origFreq[i]){
                return false;
            }
        }

        return true;
    }
}