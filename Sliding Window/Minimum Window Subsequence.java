// T.C : O(2N)
// S.C : O(1)
class Solution {
    public String minWindow(String s1, String s2) {
        int i=0,j=0, minLen = Integer.MAX_VALUE, start=-1;
        int n = s1.length(), m = s2.length();
        
        while(i<n){
            if(s1.charAt(i)==s2.charAt(j)) j++;
            
            if(j==m){
                int end = i;
                j--;
                while(j>=0){
                    if(s1.charAt(i)==s2.charAt(j)) j--;
                    i--;
                }
                i++;
                if(end-i+1<minLen){
                    minLen = end-i+1;
                    start = i;
                }
                j=0;
            }
            
            i++;
        }
        return start == -1 ? "" : s1.substring(start,start+minLen);
    }
}
