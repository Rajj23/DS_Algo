// T.C: O(m)
// S.C: O(2m)
class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();

        if(n != m) return false;

        String s1 = goal + goal;

        for(int i = 0; i <= m; i++){
            if(s1.charAt(i) == s.charAt(0) && s.equals(s1.substring(i, i+n))){
                return true;
            }
        }
        return false;
    }
}


// T.C: O(m)
// S.C: O(2m)
class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();

        if(n != m) return false;

        String s1 = goal + goal;

        for(int i = 0; i < m; i++){
            if(s1.contains(s)) return true;
        }
        return false;
    }
}