// T.C: O(n^2 * logT)
// S.C: O(1)
class Solution {
    int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public int subarrayGCD(int[] nums, int k) {
        int cnt = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int g = 0;
            for(int j = i; j < n; j++){
                g = gcd(g, nums[j]);

                if(g == k) cnt++;
                else if(g < k || g % k != 0) break;
            }
        }

        return cnt;
    }
}