//Approach (Using Greedy Allocation + Comparing LCP)
//T.C : O(n^2)
//S.C : O(n^2)
class Solution {
    int[][] checkLCP(char[] word){
        int n = word.length;

        int[][] lcp = new int[n][n];

        for(int i = 0; i < n; i++){
            lcp[i][n-1] = (word[i] == word[n-1]) ? 1 : 0;
        }

        for(int j = 0; j < n; j++){
            lcp[n-1][j] = (word[n-1] == word[j]) ? 1 : 0;
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                if(word[i] == word[j]){
                    lcp[i][j] = 1 + lcp[i+1][j+1];
                }
                else{
                    lcp[i][j] = 0;
                }
            }
        }

        return lcp;
    }
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        char[] word = new char[n];
        Arrays.fill(word, '$');

        for(int i = 0; i < n; i++){

            for(int j = 0; j < i; j++){
                if(lcp[j][i] != 0){
                    word[i] = word[j];
                    break;
                }
            }

            if(word[i] == '$'){
                boolean[] forbidden = new boolean[26];

                for(int j = 0; j < i; j++){
                    if(lcp[j][i] == 0){
                        forbidden[word[j] - 'a'] = true;
                    }
                }

                for(int j = 0; j < 26; j++){
                    if(forbidden[j] == false){
                        word[i] = (char) (j+'a');
                        break;
                    }
                }

                if(word[i] == '$'){
                    return "";
                }
            }
        }

        String result = new String(word);

        int[][] computed = checkLCP(word);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computed[i][j] != lcp[i][j]){
                    return "";
                }
            }
        }

        return result;

        // return checkLCP(word) == lcp ? word.toString() : "";
    }
}


//Approach-2 (Using Greedy Allocation + Without finding LCP)
//T.C : O(n^2)
//S.C : O(n) for word
class Solution {
    boolean checkLCP(char[] word, int[][] lcp){
        int n = word.length;

        for(int i = 0; i < n; i++){
            if(word[i] != word[n-1]){
                if(lcp[i][n-1] != 0) return false;
            }
            else{
                if(lcp[i][n-1] != 1) return false;
            }
        }

        for(int j = 0; j < n; j++){
            if(word[n-1] != word[j]){
                if(lcp[n-1][j] != 0) return false;
            }
            else{
                if(lcp[n-1][j] != 1) return false;
            }
        }

        for(int i = n-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
               if(word[i] == word[j]){
                    if(lcp[i][j] != 1 + lcp[i+1][j+1]){
                        return false;
                    }
               }
               else{
                if(lcp[i][j] != 0){
                    return false;
                }
               }
            }
        }

        return true;
    }
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        char[] word = new char[n];
        Arrays.fill(word, '$');

        for(int i = 0; i < n; i++){

            for(int j = 0; j < i; j++){
                if(lcp[j][i] != 0){
                    word[i] = word[j];
                    break;
                }
            }

            if(word[i] == '$'){
                boolean[] forbidden = new boolean[26];

                for(int j = 0; j < i; j++){
                    if(lcp[j][i] == 0){
                        forbidden[word[j] - 'a'] = true;
                    }
                }

                for(int j = 0; j < 26; j++){
                    if(forbidden[j] == false){
                        word[i] = (char) (j+'a');
                        break;
                    }
                }

                if(word[i] == '$'){
                    return "";
                }
            }
        }

        String result = new String(word);

        return checkLCP(word, lcp) == true ? result : "";
    }
}