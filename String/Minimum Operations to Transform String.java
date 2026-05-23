// T.C: O(n)
// S.C: O(1)
class Solution {
    public int minOperations(String s) {
        boolean[] freq = new boolean[26];

        int min = 26;

        for(char c : s.toCharArray()){
            if(c != 'a'){
                min = Math.min(min, c-'a');
            }
        }

        
        return 26 - min;
    }
}