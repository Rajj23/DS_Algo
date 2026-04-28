// T.C: O(n*n + 2^n)
// S.C: O(n*n)
class Solution {
    void solve(int i, List<String> list, List<List<String>> result, String s, boolean[][] t){
        if(i >= s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int idx = i; idx < s.length(); idx++){
            if(t[i][idx]){
                list.add(s.substring(i,idx+1));
                solve(idx+1, list, result, s, t);
                list.remove(list.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        int n = s.length();

        boolean[][] t = new boolean[n][n];

        for(int i = 0; i < n; i++){
            t[i][i] = true;
        }

        for(int l = 2; l <= n; l++){
            for(int i = 0; i < n-l+1; i++){
                int j = i+l-1;

                if(s.charAt(i) == s.charAt(j)){
                    if(l == 2){
                        t[i][j] = true;
                    }
                    else{
                        t[i][j] = t[i+1][j-1];
                    }
                }
            }
        }

        List<List<String>> result = new ArrayList<>();

        solve(0, new ArrayList<>(), result, s, t);

        return result;
    }
}