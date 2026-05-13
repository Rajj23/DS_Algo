//Approach - Using Difference Array Technique
//T.C : O(n)
//S.C : O(limit)
class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        int[] diff = new int[2*limit+2];

        for(int i = 0; i < n/2; i++){
            int a = nums[i];
            int b = nums[n-i-1];

            int minVal = Math.min(a, b) + 1;
            int maxVal = Math.max(a, b) + limit;

            diff[2] += 2;
            diff[2*limit+1] -= 2;

            diff[minVal] += (-1);
            diff[maxVal+1] -= (-1);

            diff[a+b] += (-1);
            diff[a+b+1] -= (-1);
        }

        int result = Integer.MAX_VALUE;

        for(int sum = 2; sum <= 2*limit; sum++){
            diff[sum] += diff[sum-1];

            result = Math.min(result, diff[sum]);
        }

        return result;
    }
}