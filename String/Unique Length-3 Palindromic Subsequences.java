// Approach 1
// T.C : O(26 * n)
// S.C : O(26)
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        Set<Character> letters = new HashSet<>();
        for(int i=0;i<n;i++){
            letters.add(s.charAt(i));
        }

        int result = 0;

        for(char letter:letters){
            int left_idx = -1;
            int right_idx = -1;

            for(int i=0;i<n;i++){
                if(s.charAt(i)==letter){
                    if(left_idx==-1){
                        left_idx = i;
                    }else{
                        right_idx=i;
                    }
                }
            }

            Set<Character> st = new HashSet<>();
            for(int middle = left_idx+1;middle<=right_idx-1;middle++){
                st.add(s.charAt(middle));
            }

            result+=st.size();
        }
        return result;
    }
}


// Approach 2
// T.C : O(26 * n)
// S.C : O(26)
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);

        for(int i=0;i<n;i++){
            int curr = s.charAt(i)-'a';
            if(first[curr]==-1){
                first[curr]=i;
            }
            last[curr]=i;
        }

        int result=0;
        for(int i=0;i<26;i++){
            if(first[i]==-1){
                continue;
            }

            Set<Character> st = new HashSet<>();
            for(int middle=first[i]+1;middle<last[i];middle++){
                st.add(s.charAt(middle));
            }

            result+=st.size();
        }
        return result;
    }
}