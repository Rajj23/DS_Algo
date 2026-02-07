// Approach: Stack
// T.C: O(n)
// S.C: O(n)
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int count = 0;

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++){
            if(!st.isEmpty() && s.charAt(i) == 'a' && st.peek() == 'b'){
                st.pop();
                count++;
            }
            else{
                st.push(s.charAt(i));
            }
        }

        return count;
    }
}

// Approach: Prefix and suffix
// T.C: O(3n)
// S.C: O(2n)
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int[] leftB = new int[n];
        int[] rightA = new int[n];

        int countB = 0;
        for(int i = 0; i < n; i++){
            leftB[i] = countB;
            if(s.charAt(i) == 'b'){
                countB++;
            }
        }

        int countA = 0;
        for(int i = n-1; i >= 0; i--){
            rightA[i] = countA;
            if(s.charAt(i) == 'a'){
                countA++;
            }
        }

        int count = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            count = Math.min(count, leftB[i] + rightA[i]);
        }

        return count;
    }
}



// Approach: Prefix and suffix
// T.C: O(2n)
// S.C: O(n)
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int[] leftB = new int[n];
        int[] rightA = new int[n];

    
        int countA = 0;
        for(int i = n-1; i >= 0; i--){
            rightA[i] = countA;
            if(s.charAt(i) == 'a'){
                countA++;
            }
        }

        int countB = 0;
        int count = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            count = Math.min(count, countB + rightA[i]);
            if(s.charAt(i) == 'b'){
                countB++;
            }
        }

        return count;
    }
}



// Approach: Prefix and suffix
// T.C: O(n)
// S.C: O(1)
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();



        int countA = 0;
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == 'a'){
                countA++;
            }
        }

        int countB = 0;
        int count = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a'){
                countA--;
            }

            count = Math.min(count, countB + countA);

            if(s.charAt(i) == 'b'){
                countB++;
            }
        }

        return count;
    }
}