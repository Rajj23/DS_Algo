// T.C : O(n)
// S.C: O(n)
class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        String s = "";

        int i = n-1, j = m-1;
        int carry = 0;

        while(i >= 0 && j >= 0){
            int c1 = a.charAt(i) - '0';
            int c2 = b.charAt(j) - '0';
            
            int sum = c1 ^ c2 ^ carry;
            carry = (c1 & c2) | (carry & (c1 ^ c2));
            s = sum + s;

            i--;
            j--;
        }

        while(i >= 0){
            int c1 = a.charAt(i) - '0';
            int sum = c1 ^ carry;
            carry = (c1 & carry);

            s = sum + s;
            i--;
        }

        while(j >= 0){
            int c1 = b.charAt(j) - '0';
            int sum = c1 ^ carry;
            carry = (c1 & carry);

            s = sum + s;
            j--;
        }

        if(carry != 0){
            s = carry + s;
        }

        return s;
    }
}


// T.C : O(n)
// S.C: O(n)
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }

            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }

           sb.append((sum%2 == 0) ? '0' : '1');

           carry = (sum > 1) ? 1 : 0;
        }

        if(carry == 1){
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}