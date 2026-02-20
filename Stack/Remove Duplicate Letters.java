// T.C: O(n)
// S.C: O(n)
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freq[c - 'a']++;
        }

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']--;

            if(vis[ch - 'a']) continue;

            while(!st.isEmpty() && st.peek() > ch && freq[st.peek() - 'a'] > 0){
                char rem = st.pop();
                vis[rem - 'a'] = false;
            }

            st.push(ch);
            vis[ch - 'a'] = true;
        }

        String str = "";
        while(!st.isEmpty()){
            str = st.pop() + str;
        }

        return str;
    }
}