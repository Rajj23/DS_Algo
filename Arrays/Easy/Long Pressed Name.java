// T.C: O(m)
// S.C: O(1)
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        int n = name.length();
        int m = typed.length();

        if(n > m) return false;

        while(i < n && j < m){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j > 0 && typed.charAt(j) == typed.charAt(j-1)){
                    j++;
                }else{
                    return false;
                }
            }
        }
        
        if (i < n) return false;

        while(j < m){
            if(typed.charAt(j) != name.charAt(n-1)){
                return false;
            }
            j++;
        }
        return true;
    }
}