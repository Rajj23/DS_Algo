// T.C: O(q*d*n)
// S.C: O(1)
class Solution {
    boolean isSame(String s1, String[] dic){
        int n = s1.length();

        for(String s2 : dic){
            int k = 0;
            boolean found = true;
            
            for(int i = 0; i < n; i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    if(k < 2){
                        k++;
                    }
                    else{
                        found = false;
                        break;
                    }
                }
            }
            if(found) return true;
        }
        return false;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        int n = queries.length;

        for(int i = 0; i < n; i++){
            if(isSame(queries[i], dictionary)){
                ans.add(queries[i]);
            }
        }

        return ans;
    }
}