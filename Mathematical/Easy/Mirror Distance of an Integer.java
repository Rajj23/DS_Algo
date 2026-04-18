// T.C: O(log(n))
// S.C: O(1)
class Solution {
    int rev(int n){
        int num = 0;

        while(n != 0){
            num = num * 10 + n%10;
            n/=10;
        }

        return num;
    }
    public int mirrorDistance(int n) {
        return Math.abs(n - rev(n));
    }
}