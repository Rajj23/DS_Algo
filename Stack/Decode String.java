// T.C: O(n + count) -> count is the integer 
// S.C: O(n)
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int count = 0;
        StringBuilder curr = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                count = count * 10 + (ch - '0');
            }
            else if(ch == '['){
                countStack.push(count);
                stringStack.push(curr.toString());
                count = 0;
                curr = new StringBuilder();
            }
            else if(ch == ']'){
                StringBuilder decodeString = new StringBuilder(stringStack.pop());
                int repeat = countStack.pop();
                for(int i = 1; i <= repeat; i++){
                    decodeString.append(curr);
                }
                curr = decodeString;
            }
            else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}