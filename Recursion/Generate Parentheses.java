// Approach: 1
// Use recursion to generate all possible strings of length 2*n consisting of
// '(' and ')'. For each position, try adding '(' and ')', and when the length
// reaches 2*n, check if the string is a valid parenthesis sequence using a
// balance counter. Only valid strings are added to the result.
// T.C: O(2^(2n) * n) in the worst case, since there are 2^(2n) candidate
// strings and each validity check via check() scans up to length 2*n.
// S.C: O(2n) = O(n) recursion depth plus O(n) for the StringBuilder used in
// construction; output list storage is O(C_n * n) for all valid strings.
class Solution {
    boolean check(StringBuilder str){
        int balance = 0;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(')
                balance++;

            else 
                balance--;

            if(balance < 0){
                return false;
            }
        }
        return balance == 0;
    }

    void fun(int n, List<String> result, StringBuilder str){
        if(str.length() == 2*n){
            if(check(str)){
                result.add(str.toString());
            }
            return;
        }

        str.append("(");
        fun(n, result, str);
        str.deleteCharAt(str.length() - 1);

        str.append(")");
        fun(n, result, str);
        str.deleteCharAt(str.length() - 1);
        
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n <= 0){
            return list;
        }

        fun(n, list, new StringBuilder());
        return list;
    }
}

// Approach: 2
// Use backtracking to build valid parenthesis strings. Track how many '(' (open)
// and ')' (close) have been used so far. At each step, you may add '(' if
// open < n, and you may add ')' if close < open. When the string length
// reaches 2*n, add it to the result list. This generates only valid
// combinations and prunes invalid ones early.
// T.C: O(C_n * n), where C_n is the nth Catalan number (number of valid
// parenthesis combinations); each of the C_n strings has length 2*n.
// S.C: O(n) auxiliary recursion stack for the current StringBuilder path,
// plus O(C_n * n) space for storing all generated strings (output space).
class Solution {
    void fun(StringBuilder str, int open, int close, int n, List<String> result){
        if(str.length() == 2*n){
            result.add(str.toString());
            return;
        }

        if(open < n){
            str.append("(");
            fun(str, open+1, close, n, result);
            str.deleteCharAt(str.length() - 1);
        }
        
        if(close < open){
            str.append(")");
            fun(str, open, close+1, n, result);
            str.deleteCharAt(str.length() - 1);
        }

    }
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        fun(new StringBuilder(), 0, 0, n, result);
        return result;
    }
}