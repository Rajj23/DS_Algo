// T.C: O(2n)
// S.C: O(n)
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        int score = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(-1);
            }
            else{
                if(st.peek() == -1){
                    st.pop();
                    st.push(1);
                }
                else{
                    int count = 0;
                    while(st.peek() != -1){
                        count += st.pop();
                    }
                    st.pop();
                    st.push(2 * count);
                }
            }
        }
        while(!st.isEmpty()){
            score += st.pop();
        }
        return score;
    }
}