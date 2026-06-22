// T.C: O(n)
// S.C: O(n)
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        char[] ch1 = String.valueOf(x).toCharArray();
        int n = ch1.length;
        
        int i = 0, j = n-1;

        while(i < j){
            if(ch1[i] != ch1[j]) return false;
            i++;
            j--;
        }

        return true;
    }
}