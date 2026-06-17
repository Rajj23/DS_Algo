//Approach (Reverse Simulation)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long l = 0;

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(l > 0)
                    l--;
            }
            else if(ch == '#'){
                l *= 2;
            }
            else if(ch == '%'){
                continue;
            }
            else{
                l++;
            }
        }

        if(k >= l) return '.';

        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == '*'){
                l++;
            }
            else if(s.charAt(i) == '%'){
                k = l - k- 1;
            }
            else if(s.charAt(i) == '#'){
                l = l/2;
                k = (k >= l) ? k - l : k;
            }
            else{
                l--;
            }

            if(k == l){
                return s.charAt(i);
            }
        }
        return '.';
    }
}