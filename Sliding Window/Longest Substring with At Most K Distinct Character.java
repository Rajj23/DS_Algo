// Approach 1
// T.C : O(2N)
// S.C : O(k)
class Solution {
    public int longestKSubstr(String s, int k) {
        code here
        Map<Character, Integer> mp = new HashMap<>();
        
        int l=0, r=0, maxLen=-1;
        
        while(r<s.length()){
            char ch = s.charAt(r);
            
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            
            while(mp.size()>k){
                char ch1 = s.charAt(l);
                mp.put(ch1,mp.get(ch1)-1);
                if(mp.get(ch1)==0){
                    mp.remove(ch1);
                }
                l++;
            }
            if(mp.size()==k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}
// Approach 2
// T.C : O(N)
// S.C : O(k)
class Solution {
    public int longestKSubstr(String s, int k) {       
        Map<Character, Integer> mp = new HashMap<>();
        
        int l=0, r=0, maxLen=-1;
        
        while(r<s.length()){
            char ch = s.charAt(r);
            
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            
            if(mp.size()>k){
                char ch1 = s.charAt(l);
                mp.put(ch1,mp.get(ch1)-1);
                if(mp.get(ch1)==0){
                    mp.remove(ch1);
                }
                l++;
            }
            if(mp.size()==k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}