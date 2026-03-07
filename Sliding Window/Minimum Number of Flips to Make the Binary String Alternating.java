//Approach-1 (Sliding Window + modifying input s = s+s)
// T.C: O(2*n)
// S.C: O(2*n)
class Solution {
    public int minFlips(String s) {
        int n = s.length();

        s = (s + s);

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();


        for(int i = 0; i < 2*n; i++){
            s1.append(i%2 == 0 ? '0' : '1');
            s2.append(i%2 == 0 ? '1' : '0');
        }

        int result = Integer.MAX_VALUE;
        int flip1 = 0;
        int flip2 = 0;

        int i = 0;
        int j = 0;

        while(j < 2*n){
            if(s.charAt(j) != s1.charAt(j)){
                flip1++;
            }  

            if(s.charAt(j) != s2.charAt(j)){
                flip2++;
            }

            if(j-i+1 > n){
                if(s.charAt(i) != s1.charAt(i)){
                    flip1--;
                }
                if(s.charAt(i) != s2.charAt(i)){
                    flip2--;
                }
                i++;
            }

            if(j-i+1 == n){
                result = Math.min(result, Math.min(flip1, flip2));
            }
            j++;
        }
        return result;
    }
}



//Approach-2 (Sliding Window + without modifying input)
//T.C : O(2*n) ~= O(n)
//S.C : O(2*n) for s1 and s2
class Solution {
    public int minFlips(String s) {
        int n = s.length();

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();


        for(int i = 0; i < 2*n; i++){
            s1.append(i%2 == 0 ? '0' : '1');
            s2.append(i%2 == 0 ? '1' : '0');
        }

        int result = Integer.MAX_VALUE;
        int flip1 = 0;
        int flip2 = 0;

        int i = 0;
        int j = 0;

        while(j < 2*n){
            if(s.charAt(j%n) != s1.charAt(j)){
                flip1++;
            }  

            if(s.charAt(j%n) != s2.charAt(j)){
                flip2++;
            }

            if(j-i+1 > n){
                if(s.charAt(i%n) != s1.charAt(i)){
                    flip1--;
                }
                if(s.charAt(i%n) != s2.charAt(i)){
                    flip2--;
                }
                i++;
            }

            if(j-i+1 == n){
                result = Math.min(result, Math.min(flip1, flip2));
            }
            j++;
        }
        return result;
    }
}


//Approach-3 (Sliding Window + without modifying input)
//T.C : O(2*n) ~= O(n)
//S.C : O(1)
class Solution {
    public int minFlips(String s) {
        int n = s.length();

        int result = Integer.MAX_VALUE;
        int flip1 = 0;
        int flip2 = 0;

        int i = 0;
        int j = 0;

        while(j < 2*n){
            char exceptectedCharS1 = (j%2 == 0) ? '1' : '0';
            char exceptectedCharS2 = (j%2 == 0) ? '0' : '1';

            if(s.charAt(j%n) != exceptectedCharS1){
                flip1++;
            }  

            if(s.charAt(j%n) != exceptectedCharS2){
                flip2++;
            }

            if(j-i+1 > n){
                exceptectedCharS1 = (i%2 == 0) ? '1' : '0';
                exceptectedCharS2 = (i%2 == 0) ? '0' : '1';

                if(s.charAt(i%n) != exceptectedCharS1){
                    flip1--;
                }
                if(s.charAt(i%n) != exceptectedCharS2){
                    flip2--;
                }
                i++;
            }

            if(j-i+1 == n){
                result = Math.min(result, Math.min(flip1, flip2));
            }
            j++;
        }
        return result;
    }
}