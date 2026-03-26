//Approach-1 (Using Simple LIS recursion+memo) - We sort it in the beginning to get words ordered in ascending order based on length
// T.C : O(n*n*n)
// S.C: O(n*n)
class Solution {
    boolean isValid(String s1, String s2){
        if(s1.length() + 1 == s2.length()){
            int i = 0;
            int j = 0;
            int k = 1;
            int n = s1.length(), m = s2.length();

            while(i < n && j < m){
                if(s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }
                else if (k == 1 && j+1 < m && s1.charAt(i) == s2.charAt(j+1)){
                    i++;
                    j += 2;
                    k--;
                }
                else{
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    int[][] t;
    int solve(int idx, int prev, String[] words){
        int n = words.length;
        if(idx == n){
            return 0;
        }

        if(t[idx][prev] != -1) return t[idx][prev];

        int take = 0;
        if(prev == n || isValid(words[prev], words[idx])){
            take = 1 + solve(idx+1, idx, words);
        }

        int skip = solve(idx+1, prev, words);

        return t[idx][prev] = Math.max(take, skip);
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b)-> Integer.compare(a.length(), b.length()));

        t = new int[n][n+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(t[i], -1);
        }

        return solve(0, n, words);
    }
}


//Approach-2 (Using Simple LIS Bottom Up) - We sort it in the beginning to get words ordered in ascending order based on length
// T.C : O(n*n*n)
// S.C: O(n)
class Solution {
    boolean isValid(String s1, String s2){
        if(s1.length() + 1 == s2.length()){
            int i = 0;
            int j = 0;
            int k = 1;
            int n = s1.length(), m = s2.length();

            while(i < n && j < m){
                if(s1.charAt(i) == s2.charAt(j)){
                    i++;
                    j++;
                }
                else if (k == 1 && j+1 < m && s1.charAt(i) == s2.charAt(j+1)){
                    i++;
                    j += 2;
                    k--;
                }
                else{
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b)-> Integer.compare(a.length(), b.length()));

        int[] t = new int[n];
        Arrays.fill(t, 1);

        int result = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(isValid(words[j], words[i])){
                    t[i] = Math.max(t[i], t[j]+1);
                    result = Math.max(result, t[i]);
                }
            }
        }

        return result;
    }
}