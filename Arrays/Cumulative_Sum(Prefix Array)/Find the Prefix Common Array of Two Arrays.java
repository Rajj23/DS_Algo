// Approach: 1
// T.C: O(n)
// S.C: O(2n)
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        Set<Integer> stA = new HashSet<>();
        Set<Integer> stB = new HashSet<>();

        int[] result = new int[n];

        if(A[0] == B[0]){
            result[0] = 1;
        }
        stA.add(A[0]);
        stB.add(B[0]);

        for(int i = 1; i < n; i++){
            result[i] = result[i-1];

            if(A[i] == B[i]){
                result[i]++;
            }
            else{
                if(stA.contains(B[i])){
                    result[i]++;
                }
                if(stB.contains(A[i])){
                    result[i]++;
                }
            }

            stA.add(A[i]);
            stB.add(B[i]);
        }

        return result;
    }
}


// Approach: 2
// T.C: O(n)
// S.C: O(n)
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] freq = new int[n+1];
        int[] result = new int[n];

        int count = 0;
        for(int i = 0; i < n; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2){
                count++;
            }

            freq[B[i]]++;
            if(freq[B[i]] == 2){
                count++;
            }

            result[i] = count;
        }

        return result;
    }
}