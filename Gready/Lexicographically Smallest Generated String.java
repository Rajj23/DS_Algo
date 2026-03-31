//Approach (Using Greedy)
//T.C : O(n*m)
//S.C : O(n+m-1)
class Solution {

    boolean isSame(char[] word, String str2, int i, int m){
        for(int j = 0; j < m; j++){
            if(word[i + j] != str2.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] word = new char[n + m - 1];
        boolean[] canChange = new boolean[m + n - 1];

        Arrays.fill(word, '$');

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i+j] != '$' && word[i + j] != str2.charAt(j))
                        return "";
                    
                    word[i + j] = str2.charAt(j);
                }
            } 
        }

        for(int i = 0; i < n+m-1; i++){
            if(word[i] == '$'){
                word[i] = 'a';
                canChange[i] = true;
            }
        }

        for(int i = 0; i < n; i++){
            if(str1.charAt(i) == 'F'){

                if(isSame(word, str2, i, m)){
                    boolean changed = false;
                    for(int k = i+m-1; k >= i; k--){
                        if(canChange[k] == true){
                            word[k] = 'b';
                            changed = true;
                            break;
                        }
                    }
                    if(changed == false){
                        return "";
                    }
                }
            }
        }

        return new String(word);
    }
}