// T.C: O(n*m)
// S.C: O(1)
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

        StringBuilder sb = new StringBuilder();
        
        int n = words.length;
        for(int i = 0; i < n; i++){
            
            String s1 = words[i];

            int sum = 0;
            for(char c :s1.toCharArray()){
                sum += weights[c-'a'];
            }

            int currChar = sum % 26;
            System.out.println(currChar);
            sb.append((char) ('a' + (25 - currChar)));
        }

        return sb.toString();
    }
}