// T.C: O(n)
// S.C: O(n)
class Solution {
    int MOD = (int)1e9+7;
    Map<String, Integer> t;
    int solve(int pos, int end, int k){
        if(Math.abs(end-pos) > k) return 0;
        
        if(k == 0){
            if(pos == end) return 1;
            return 0;
        }
        
        String key = pos + "_" + k;
        if(t.containsKey(key)) return t.get(key);
            
        int front = solve(pos+1, end, k-1);
        int back = solve(pos-1, end, k-1);

        int steps = (front + back) % MOD;
        t.put(key, steps);
        return steps;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        t = new HashMap<>();
        return solve(startPos, endPos, k);
    }
}