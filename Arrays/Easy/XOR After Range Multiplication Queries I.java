//Approach (Straight forward simulation)
//T.C : O(n*q),  n = nums.size(), and q = queries.size()
//S.C : O(1)
class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = (int) 1e9+7;
        for(int[] querie : queries){
            int idx = querie[0];

            while(idx <= querie[1]){
                long temp = ((long) nums[idx] * querie[3]) % MOD;
                nums[idx] = (int) temp;
                idx += querie[2];
            }
        }

        int XOR = nums[0];
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            XOR = XOR ^ num;
        }

        return XOR;
    }
}