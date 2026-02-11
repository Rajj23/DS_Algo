class Solution {
    static int[][] t;
    public static int solve(int i, int j, int[] arr){
        if(i == j) return 0;
        
        if(t[i][j] != -1) return t[i][j];
        
        int min = Integer.MAX_VALUE;
        
        for(int k = i; k < j; k++){
            int steps = arr[i-1] * arr[k] * 
                        arr[j] + solve(i, k, arr) + solve(k+1, j, arr);
            
            min = Math.min(min, steps);
        }
        return t[i][j] = min;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        
        t = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(t[i], -1);
        }
        
        return solve(1, n-1, arr);
    }
}