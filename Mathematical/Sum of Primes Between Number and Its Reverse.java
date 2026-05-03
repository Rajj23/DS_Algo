// T.C: (nlogn)
// S.C: O(1)
class Solution {
    int reverse(int num){
        int temp = 0;

        while(num > 0){
            int digit = num%10;
            temp = temp * 10 + digit;
            num /= 10;
        }
        return temp;
    }

    boolean isPrime(int num){
        if(num < 2) return false;
        for(int i = 2; i*i <= num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    
    public int sumOfPrimesInRange(int n) {
        int r = reverse(n);
        int sum = 0;

        for(int i = Math.min(n, r); i <= Math.max(r, n); i++){
            if(isPrime(i)){
                sum += i;
            }
        }
        return sum;
    }
}