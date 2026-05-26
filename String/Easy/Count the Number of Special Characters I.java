// T.C: O(n)
// S.C: O(1)
class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        for(char ch : word.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                upper[ch-'A']++;
            }
            else{
                lower[ch-'a']++;
            }
        }

        int result = 0;
        for(int i = 0; i < 26; i++){
            if(lower[i] > 0 && upper[i] > 0){
                result++;
            }
        }

        return result;
    }
}