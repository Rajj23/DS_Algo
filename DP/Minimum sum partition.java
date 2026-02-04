// Approach: Memoization
// T.C: O(n)
// S.C: O(2n)
class Solution {
    
    int[][] t;
    int totalSum = 0;
    
    int solve(int idx, int[] arr, int currSum){
        if(idx == arr.length){
            
            return Math.abs(totalSum - 2 * currSum);
        }
        
        if(t[idx][currSum] != -1) return t[idx][currSum];
        
        int take = solve(idx+1, arr, currSum + arr[idx]);
        int notTake = solve(idx+1, arr, currSum);
        
        return t[idx][currSum] =  Math.min(take, notTake);
    }

    public int minDifference(int arr[]) {
        // Your code goes here
        
        int n = arr.length;
        for(int a : arr){
            totalSum += a;
        }
        
        t = new int[n+1][totalSum+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(t[i], -1);
        }
        
        return (int) solve(0, arr, 0);
    }
}



// Approach: Tabulization
// T.C: O(n)
// S.C: O(2n)
class Solution {
    public int minDifference(int arr[]) {
        int totalSum = 0;
        int n = arr.length;
        for(int a : arr){
            totalSum += a;
        }
        
        int[][] t = new int[n+1][totalSum+1];
        
        for(int i = 0; i <= totalSum; i++){
            t[n][i] = Math.abs(totalSum - 2*i);
        }
        
        for(int i = n-1; i >= 0; i--){
            for(int sum = 0; sum <= totalSum; sum++){
                int take = Integer.MAX_VALUE;
                
                if(sum + arr[i] <= totalSum){
                    take = t[i+1][sum+arr[i]];
                }
                
                int notTake = t[i+1][sum];
                
                t[i][sum] = Math.min(take, notTake);
            }
        }
        
        return t[0][0];
    }
}
    
