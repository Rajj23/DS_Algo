// Approach: Use backtracking to generate all possible strings. For each
// position i in the input digits string, iterate over the characters
// mapped from the current digit and append each to the current prefix,
// recursing to build the next position. When i reaches digits.length(),
// add the built string to the result list.
// T.C: O(4^n), where n is the number of digits, since each digit maps
// to at most 4 letters and we generate all combinations (output size
// is also O(4^n)).
// S.C: O(n) for recursion stack depth plus O(4^n) for storing all
// generated combinations in the result list.
class Solution {
    Map<Integer, char[]> mp = new HashMap<>();

    void fun(int i, String digits, List<String> result, String curr){
        if(i == digits.length()){
            result.add(curr);
            return;
        }
        
        int d = digits.charAt(i) - '0';
        for(char c : mp.get(d)){
            fun(i+1, digits, result, curr+c);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        mp.put(2, new char[]{'a','b','c'});
        mp.put(3, new char[]{'d','e','f'});
        mp.put(4, new char[]{'g','h','i'});
        mp.put(5, new char[]{'j','k','l'});
        mp.put(6, new char[]{'m','n','o'});
        mp.put(7, new char[]{'p','q','r','s'});
        mp.put(8, new char[]{'t','u','v'});
        mp.put(9, new char[]{'w','x','y','z'});

        List<String> result = new ArrayList<>();

        fun(0, digits, result, "");

        return result;

    }
}