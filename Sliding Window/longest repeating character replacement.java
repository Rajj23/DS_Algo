// Approach 1
// T.C : O(N*N)
// S.c : O(26)
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen=0;
        for(int i=0;i<n;i++){
            int[] hash = new int[26];
            int maxFeq=0;
            for(int j=i;j<n;j++){
                hash[s.charAt(j)-'A']++;
                maxFeq = Math.max(maxFeq,hash[s.charAt(j)-'A']);
                int changes = (j-i+1) - maxFeq;
                if(changes<=k){
                    maxLen = Math.max(maxLen,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
}


// Approach 2
// T.C : O(N + N)*26
// S.c : O(26)
class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxLen=0,maxFreq=0;
        int n = s.length();
        int[] hash = new int[26];
        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,hash[s.charAt(r)-'A']);
            while((r-l+1)-maxFreq>k){
                hash[s.charAt(l)-'A']--;
                maxFreq=0;
                for(int feq:hash){
                    maxFreq=Math.max(feq,maxFreq);
                }
                l++;
            }
            if((r-l+1)-maxFreq<=k){
                maxLen = Math.max(maxLen,(r-l+1));
            }
            r++;
        }
        return maxLen;



// Approach 3
// T.C : O(N)
// S.c : O(26)
class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxLen=0,maxFreq=0;
        int n  = s.length();
        int[] hash = new int[26];
        while(r<n){
            hash[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,hash[s.charAt(r)-'A']);
            if((r-l+1)-maxFreq>k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            if((r-l+1)-maxFreq<=k){
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}