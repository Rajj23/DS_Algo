// T.C: O(2n)
// S.C: O(n)
class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
        if(s1.length() != s2.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char c : s2.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)  - 1);
                
                if(map.get(c) == 0){
                    map.remove(c);
                }
            }
            else{
                if(k > 0){
                    k--;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}