// T.C: O(n)
// S.C: O(1)
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        for(char ch : word.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                if(upper[ch-'a'] != 0){
                    lower[ch-'a'] = -1;
                }
                else{
                    lower[ch-'a']++;
                }
            }
            else{
                if(upper[ch - 'A'] == -1) continue;
                upper[ch-'A']++;
            }
        }

        int ans = 0;
        for(int i = 0; i < 26; i++){
            if(lower[i] > 0 && upper[i] > 0){
                ans++;
            }
        }

        return ans;
    }
}