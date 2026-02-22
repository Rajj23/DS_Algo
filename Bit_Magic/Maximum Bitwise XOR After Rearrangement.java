// T.C: O(n)
// S.C: O(n)
class Solution {
    public String maximumXor(String s, String t) {
        int sZero = 0;
        int sOne = 0;
        int tZero = 0;
        int tOne = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            int dig2 = t.charAt(i);
            if(dig2 == '0'){
                tZero++;
            }
            else{
                tOne++;
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                if(tOne > 0){
                     str.append("1");
                    tOne--;
                }
                else{
                    str.append("0");
                    tZero--;
                }
            }
            else{
                if(tZero > 0){
                    str.append("1");
                    tZero--;
                }
                else{
                    str.append("0");
                    tOne--;
                }
            }
        }

        return str.toString();
    }
}