//Approach-1 (Simple simulation with extra space)
//T.C : O(l), l = encodedText.length()
//S.C : O(l), all characters of encodedText in matrix
// T.C : O(l)
// S.C : O(l)
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
       
        
        char[][] mat = new char[rows][cols];

        int idx = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                mat[i][j] =  encodedText.charAt(idx++);

              
            }
        }

        StringBuilder sb = new StringBuilder();
        for(idx = 0; idx < cols; idx++){
            int i = 0;
            int j = idx;

            while(i < rows && j < cols){
                sb.append(mat[i][j]);
                i++;
                j++;
            }
        }

        n = sb.length();
        for(int i = n-1; i >= 0; i--){
            if(sb.charAt(i) == ' '){
                sb.deleteCharAt(i);
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}