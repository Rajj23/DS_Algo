// T.C: O(n)
// S.C: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int i = 0, j = 0;
        Set<Character> st = new HashSet<>();
        int ans = 0;

        while(j < n){
            char ch = s.charAt(j);

            while(i <= j && st.contains(ch)){
                char temp = s.charAt(i);
                st.remove(temp);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            st.add(ch);
            j++;
        }

        return ans;
    }
}