// T.C: O(n)
// S.C: O(1)
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        int n = s.length();

        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(freq[c-'a'] == 1) return i;
        }

        return -1;
    }
}