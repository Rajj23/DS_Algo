//Approach (Brute Force All Possible Answers)
//T.C : O(n*k)
//S.C : O(2^k * k), storing 2^k substrings of length k each
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> st = new HashSet<>();

        int i = 0, n = s.length();

        for(int j = k; j <= n; j++){
            st.add(s.substring(i, j));
            i++;
        }

        return st.size() == (int) Math.pow(2, k);
    }
}


//Approach (Brute Force All Possible Answers)
//T.C : O(n*k)
//S.C : O(2^k * k), storing 2^k substrings of length k each
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> st = new HashSet<>();

        int i = 0, n = s.length();
        int count = 1 << k;

        for(int j = k; j <= n; j++){
            String sub = s.substring(i, j);
            if(!st.contains(sub)){
                st.add(sub);
                count--;
            }
            if(count == 0) return true;
            i++;
        }

        return false;
    }
}