class Solution {
    public int longestValidParentheses(String s) {
        // Stack<Integer> st = new Stack<>();
        // st.push(-1);

        // int ans = 0;

        // for(int i = 0; i < s.length(); i++){
        //     char c = s.charAt(i);

        //     if(c == '('){
        //         st.push(i);
        //     }
        //     else{
        //         st.pop();
        //         if(st.isEmpty()) st.push(i);
        //         else{
        //             int prev = st.peek();
        //             ans = Math.max(ans, i - prev);
        //         }
        //     }
        // } 

        // return ans;

        int open = 0;
        int close = 0;
        int maxL = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }

            if(open == close){
                maxL = Math.max(maxL, 2 * close);
            }
            else if(close > open){
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == ')'){
                close++;
            }
            else{
                open++;
            }

            if(open == close){
                maxL = Math.max(maxL, 2 * open);
            }
            else if(open > close){
                open = 0;
                close = 0;
            }
        }

        return maxL;
    }
}