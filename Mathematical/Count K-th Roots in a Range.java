// T.C :O(k)
// S.C: O(1)
class Solution {
    public int countKthRoots(int l, int r, int k) {
        int ans = 0;
        int x = 0;

        if(k == 1) return r-l+1;

        while(true){
            long y = (long) Math.pow(x, k);
            if(y > r) break;
            if(y >= l) ans++;
            x++;
        }
        return ans;
    }
}