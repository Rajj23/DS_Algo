// ********************************************************************** JAVA ************************************************************************

// T.C: O(n)
// S.C: O(1)
class Solution {
    public int countPermutations(int[] complexity) {
        int M = 1_000_000_007;                                                             

        int min = complexity[0];
        int n = complexity.length;
        long result = 1;
        for(int i=1;i<n;i++){
            if(min >= complexity[i]){
                return 0;
            }
            result = (result * i) % M;
        }

        return (int)result;
    }
}