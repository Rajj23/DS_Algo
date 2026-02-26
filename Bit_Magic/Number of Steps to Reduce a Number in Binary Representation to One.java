// T.C: O(n^2)
// S.C: O(1)
class Solution {
    StringBuilder sb;

    void addOne(){
        int i = sb.length() - 1;

        while(i >= 0 && sb.charAt(i) != '0'){
            sb.setCharAt(i, '0');
            i--;
        }

        if(i >= 0){
            sb.setCharAt(i, '1');
        }
        else{
            sb.insert(0, '1');
        }
    }

    public int numSteps(String s) {
        int n = s.length();
        int count = 0;

        sb = new StringBuilder(s);
    
        while(sb.length() > 1){
            if(sb.charAt(sb.length() - 1) == '0'){
                count++;
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                addOne();
                count++;
            }
        }
        return count;
    }
}



// T.C: O(n)
// S.C: O(1)
class Solution {
    public int numSteps(String s) {
        int n = s.length();

        int op = 0;
        int carry = 0;

        for(int i = n-1; i >= 1; i--){
            if(((s.charAt(i) - '0') + carry) % 2 == 1){
                op += 2;
                carry = 1;
            }
            else{
                op += 1;
            }
        }

        return op + carry;
    }
}