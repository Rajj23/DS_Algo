// T.C: O(n)
// S.C: O(n)
class Solution {
    public int mirrorFrequency(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }

        boolean[] pickedChar = new boolean[26];
        boolean[] pickedNum = new boolean[10];
        
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                char ch2 = (char) ('a' + 'z' - ch);
                if(!pickedChar[ch - 'a'] && !pickedChar[ch2 - 'a']){
                    ans += Math.abs((mp.getOrDefault(ch, 0) - mp.getOrDefault(ch2, 0)));
                    pickedChar[ch - 'a'] = true;
                    pickedChar[ch2 - 'a'] = true;
                }
            }            
            else{
                char ch2 = (char) ('0' + '9' - ch);
                if(!pickedNum[ch - '0'] && !pickedNum[ch2 - '0']){
                    ans += Math.abs((mp.getOrDefault(ch, 0) - mp.getOrDefault(ch2, 0)));
                    pickedNum[ch - '0'] = true;
                    pickedNum[ch2 - '0'] = true;
                }
            }
        }
        return ans;
    }
}