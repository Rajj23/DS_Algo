//Approach-1 (Recursion + Memoization)
//T.C : O(n*d)
//S.C : O(n)
class Solution {
    int n;
    int[] t;

    int solve(int i, int[] arr,int d){
        if(i < 0 || i >= n) return 0;

        if(t[i] != -1) return t[i];

        int max = 0;
        for(int x = 1; x <= d; x++){
            if(i-x < 0) break;
            if(arr[i-x] >= arr[i]) break;

            max = Math.max(max, 1 + solve(i-x, arr, d));
        }
        for(int x = 1; x <= d; x++){
            
            if(i+x >= n) break;
            if(arr[i+x] >= arr[i]) break;
            
            max = Math.max(max, 1 + solve(i+x, arr, d));
        }
        return t[i] = max;
    }
    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        t = new int[n];
        Arrays.fill(t, -1);

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, 1 + solve(i, arr, d));
        }
        return max;
    }
}

//Approach-2 (Bottom-Up DP using Sorting)
//T.C : O(n*d)
//S.C : O(n)
class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;

        int[] t = new int[n+1];
        Arrays.fill(t, -1);

        int[][] pair = new int[n][2];

        for(int i = 0; i < n; i++){
            pair[i][0] = arr[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b)->{
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for(int[] it : pair){
            int val = it[0];
            int i = it[1];

            int result = 1;

            for(int j = i-1; j >= Math.max(0, i-d); j--){
                if(arr[j] >= arr[i]) break;

                result = Math.max(result, 1+t[j]);
            }

            for(int j = i+1; j <= Math.min(n-1, i+d); j++){
                if(arr[j] >= arr[i]) break;

                result = Math.max(result, 1+t[j]);
            }
            
            t[i] = result;
        }

        int maxCountIndices = 0;
        for(int i = 0; i < n; i++){
            maxCountIndices = Math.max(maxCountIndices, t[i]);
        }
        return maxCountIndices;
    }
}

Here we are trying to merge 2 branch. Merge are being trying with conflict. New thing trying.