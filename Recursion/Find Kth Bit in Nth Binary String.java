// T.C: O(n!)
// S.C: O(n!)
class Solution {
    String reverse(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.append("1");

        int j = n-1;
        while(j >= 0){
            char ch  = s.charAt(j);
            if(ch == '0'){
                sb.append("1");
            }
            else{
                sb.append("0");
            }
            j--;
        }
        return sb.toString();
    }

    String solve(int n){
        if(n <= 1){
            return "0";
        }

        String prev = solve(n-1);
        return reverse(prev);
    }
    public char findKthBit(int n, int k) {
        String s = solve(n);
        System.out.println(s);
        return s.charAt(k-1);
    }
}


// T.C: O(n)
// S.C: O(n)
class Solution {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';
        int length = (1 << n) - 1;

        if(k < Math.ceil(length/2.0)){
            return findKthBit(n-1, k);
        }
        else if(k == Math.ceil(length/2.0)){
            return '1';
        }
        else{
            char ch = findKthBit(n-1, length - (k-1));
            return ch == '0' ? '1' : '0';
        }
    }
}