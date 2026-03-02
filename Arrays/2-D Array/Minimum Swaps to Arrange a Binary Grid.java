//Approach (Siilar to Bubble Sort - Find best candidate and swap)
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;

        int[] trailZeros = new int[n];
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = n-1; j >= 0; j--){
                if(grid[i][j] == 1) break;
                count++;
            }
            trailZeros[i] = count;
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            int needZero = n - i - 1;

            int j = i;
            while(j < n &&trailZeros[j] < needZero){
                j++;
            }
            if(j == n){
                return -1;
            }

            while(j > i){
                count++;
                int temp = trailZeros[j];
                trailZeros[j] = trailZeros[j-1];
                trailZeros[j-1] = temp;
                j--;
            }
        }

        return count;
    }
}