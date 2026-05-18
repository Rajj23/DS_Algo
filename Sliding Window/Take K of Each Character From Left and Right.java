// T.C: O(n)
// S.C: O(1)
class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int a = 0, b = 0, c = 0;

        for(char ch : s.toCharArray()){
            if(ch == 'a') a++;
            else if(ch == 'b') b++;
            else c++;
        }

        if(a < k || b < k || c < k) return -1;

        int i = 0, j = 0;
        int notDeletedWindowSize = 0;

        while(j < n){
            
            if(s.charAt(j) == 'a'){
                a--;
            }
            else if(s.charAt(j) == 'b'){
                b--;
            }
            else{
                c--;
            }

            while(i <= j && (a < k || b < k || c < k)){
                if(s.charAt(i) == 'a'){
                    a++;
                }
                else if(s.charAt(i) == 'b'){
                    b++;
                }
                else{
                    c++;
                }
                i++;
            }
            notDeletedWindowSize = Math.max(notDeletedWindowSize, j-i+1);
            j++;
        }

        return n - notDeletedWindowSize;
    }
}