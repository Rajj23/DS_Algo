// T.C: O(n)
// S.C: O(n)
class Solution {
    public boolean isValid(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            char ch = s.charAt(i);

            if(ch == ')' || ch == '}' || ch == ']'){
                st.add(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                char close = st.pop();

                if(ch == '('){
                    if(close != ')') return false;
                }
                else if(ch == '['){
                    if(close != ']') return false;
                }
                else{
                    if(close != '}') return false;
                }
            }
        }

        return st.isEmpty();
    }
}