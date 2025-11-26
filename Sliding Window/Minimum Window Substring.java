// T.C : O(2*N) + O(M)
// S.C : O(256)
class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int l=0,r=0,minLen = 1_000_000_007,sIdx=-1;
        int m = t.length(),n=s.length(),cnt=0;

        for(int i=0;i<m;i++){
            hash[t.charAt(i)]++;
        }

        while(r<n){
            if(hash[s.charAt(r)]>0) cnt++;
            hash[s.charAt(r)]--;
            while(cnt==m){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    sIdx=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) cnt--;
                l++;
            }
            r++;
        }
        return sIdx==-1 ? "" : s.substring(sIdx,sIdx+minLen);
    }
}