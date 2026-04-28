// T.C: O(m*n log(m*n))
// S.C: O(m*n)
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] nums = new int[m*n];
        int rem = -1;

        int k = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    rem = grid[i][j] % x;
                }

                nums[k++] = grid[i][j];

                if(grid[i][j]%x != rem) return -1;
            }
        }

        Arrays.sort(nums);

        int num1 = (m*n)/2;

        int cnt1 = 0, cnt2 = 0;
        for(int i = 0; i < m*n; i++){
            int diff1 = Math.abs(nums[i] - nums[num1]);

            cnt1 += diff1/x;
        }
        return cnt1;
    }
}