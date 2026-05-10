// T.C: O(n+q)
// S.C: O(n)
class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        int n = chunks.length;
        int m = queries.length;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(chunks[i]);
        }

        String s = sb.toString();
        Map<String, Integer> mp = new HashMap<>();

        int i = 0;
        n = s.length();

        while(i < n){
            while(i < n && !Character.isLowerCase(s.charAt(i))){
                i++;
            }

            StringBuilder word = new StringBuilder();

            while(i < n){
                char ch = s.charAt(i);
                if(Character.isLowerCase(ch)){
                    word.append(ch);
                    i++;
                }
                else if(ch == '-' && i-1 >= 0 && i+1 < n &&
                       Character.isLowerCase(s.charAt(i-1)) 
                       && Character.isLowerCase(s.charAt(i+1))){
                            word.append(ch);
                            i++;
                }
                else{
                    break;
                }
            }
            if(word.length() > 0){
                String w = word.toString();
                mp.put(w, mp.getOrDefault(w, 0)+1);
            }
            i++;
        }
        

        int[] result = new int[m];
        for(i = 0; i < m; i++){
            if(mp.containsKey(queries[i])){
                result[i] = mp.get(queries[i]);
            }
            else{
                result[i] = 0;
            }
        }
        
        return result;
    }
}