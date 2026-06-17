// T.C: O(2^n)
// S.C: O(2^n)
class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            }
            else if(ch == '*'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else if(ch == '#'){
                sb.append(sb);
            }
            else{
                sb.reverse();
            }
        }

        return sb.toString();
    }
}