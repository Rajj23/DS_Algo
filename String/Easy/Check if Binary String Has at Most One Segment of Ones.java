//T.C : O(n)
//S.C : O(1)
class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean findZero = false;

        for(int i = 1 ; i < n; i++){
            if(s.charAt(i) == '0' && s.charAt(i-1) == '1'){
                findZero = true;
            }

            if(findZero == true && s.charAt(i) == '1') return false;
        }

        return true;
    }
}


//T.C : O(n)
//S.C : O(1)
class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean findZero = false;

        for(int i = 1 ; i < n; i++){
            if(s.charAt(i) == '1' && s.charAt(i-1) == '0'){
                return false;
            }
        }

        return true;
    }
}

//T.C : O(n)
//S.C : O(1)
class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}