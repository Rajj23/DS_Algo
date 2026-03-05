// T.C: O(2n)
// S.C: O(2n)
class Solution {
    public int minOperations(String s) {
        StringBuilder zero = new StringBuilder();
        StringBuilder one = new StringBuilder();

        int n = s.length;
        int zero = 0;
        int one = 1;

        for(int i = 0; i < n; i++){
            zero.append(zero);
            one.append(one);

            zero = 1 - zero;
            one = 1 - one;
        }

        zero = 0;
        one = 0;

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c != zero.charAt(i)){
                zero++;
            }

            if(c != one.charAt(i)){
                one++;
            }
        }

        return Math.min(zero, one);
    }
}


// T.C: O(n)
// S.C: O(1)
class Solution {
    public int minOperations(String s) {

        int n = s.length();
        char z = '0';
        char o = '1';
        int zero = 0;
        int one = 0;

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(z != c){
                zero++;
            }

            if(o != c){
                one++;
            }

            char temp = z;
            z = o;
            o = temp;
        }

        return Math.min(zero, one);
    }
}



// T.C: O(n)
// S.C: O(1)
class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int start_with_0 = 0;

        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                if(s.charAt(i) == '1'){
                    start_with_0++;
                }
            }
            else{
                if(s.charAt(i) == '0'){
                    start_with_0++;
                }
            }
        }

        return Math.min(start_with_0, n - start_with_0);
    }
}