// T.C: O(n*3*2(n-1)) ~= O(n*2^n)
// S.C: O(n * 2*n)
class Solution {
    void solve(int n, StringBuilder curr, List<String> result){
        if(curr.length() == n){
            result.add(curr.toString());
            return;
        }

        for(char ch = 'a'; ch <= 'c'; ch++){
            if(curr.length() > 0 && curr.charAt(curr.length()-1) == ch) continue;

            curr.append(ch);
            solve(n, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        StringBuilder curr = new StringBuilder();
        List<String> result = new ArrayList<>();

        solve(n, curr, result);

        if(result.size() < k){
            return "";
        }

        return result.get(k - 1);
    }
}

// T.C: O(n*3*2(n-1)) ~= O(n*2^n)
// S.C: O(n)
class Solution {
    int count = 0;
    String solve(int idx, int n, int k, StringBuilder sb){
        if(idx == n){
            count++;
            if(count == k){
                return sb.toString();
            }
            return "";
        }

        for(int i = 0; i < 3; i++){
            if(sb.length() == 0){
                sb.append((char) ('a' + i));
                String s = solve(idx+1, n, k, sb);
                if(!s.equals("")) return s;
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                if(sb.charAt(sb.length()-1) == (char) ('a' + i)){
                    continue;
                }
                else{
                    sb.append((char) ('a' + i));
                    String s = solve(idx+1, n, k, sb);
                    if(!s.equals("")) return s;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return "";
    }
    public String getHappyString(int n, int k) {
        return solve(0, n, k, new StringBuilder());
    }
}
