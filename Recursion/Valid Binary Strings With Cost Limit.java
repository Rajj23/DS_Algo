// T.C: O(2^n)
// S.C: O(n)
class Solution {
    void solve(int i, StringBuilder sb, int cost, boolean prevOne, int n, int k, List<String> result){
        if(cost > k) return;
        if(sb.length() == n){
            result.add(sb.toString());
            return;
        }
        sb.append('0');
        solve(i+1, sb, cost, false, n, k, result);
        sb.deleteCharAt(sb.length()-1);

        if(!prevOne){
            sb.append('1');
            solve(i+1, sb, cost+i, true, n, k, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public List<String> generateValidStrings(int n, int k) {
        List<String> result = new ArrayList<>();

        solve(0, new StringBuilder(), 0, false, n, k, result);
        return result;
    }
}