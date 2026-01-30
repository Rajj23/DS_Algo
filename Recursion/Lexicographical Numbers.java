/*
APPROACH:
- Use recursion to build numbers in lexicographical order
- Start with digits 1-9 and recursively append digits 0-9 to each
- This naturally generates numbers in lexicographical order
- Base case: if current number exceeds n, stop recursion
- For each valid number, append it to result and try appending next digits

TIME COMPLEXITY: O(n)
- We visit each number from 1 to n exactly once
- Processing each number takes constant time

SPACE COMPLEXITY: O(log n)
- Recursion depth is at most log₁₀(n) since we build numbers digit by digit
- At maximum depth, we have log₁₀(n) recursive calls on the stack
- Output list stores n numbers but doesn't count toward auxiliary space
*/

class Solution {
    void fun(int i, int n, List<Integer> result){
        if(i > n) return;

        result.add(i);

        for(int j = 0; j <= 9; j++){
            fun(i*10+j, n, result);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= 9; i++)
            fun(i,n, result);
        return result;
    }
}