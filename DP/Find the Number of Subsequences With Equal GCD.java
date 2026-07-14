//Approach-1 (Recursion + Memoization)
//T.C : O(n * M * M), M = max element 
//S.C : O(n * M * M), M = max element
class Solution {
    int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b, a % b);
    }

    int[][][] t;
    int MOD = (int) 1e9 + 7;

    int solve(int[] nums, int i, int first, int second){
        if(i == nums.length){
            boolean bothNonEmpty = (first != 0 && second != 0);
            boolean gcdMatch = (first == second);

            return (bothNonEmpty && gcdMatch) ? 1 : 0;
        }

        if(t[i][first][second] != -1) return t[i][first][second];

        int skip = solve(nums, i+1, first, second);

        int take1 = solve(nums, i+1, gcd(first, nums[i]), second);

        int take2 = solve(nums, i+1, first, gcd(nums[i], second));

        return t[i][first][second] = (int) ((long) take1 + (long) take2 + (long) skip) % MOD;

    }

    public int subsequencePairCount(int[] nums) {
        t = new int[201][201][201];
        for(int i = 0; i < 201; i++){
            for(int j = 0; j < 201; j++){
                Arrays.fill(t[i][j], -1);
            }
        }

        return solve(nums, 0, 0, 0);
    }
}



//Approach-2 (Bottom Up)
//T.C : O(n * M * M), M = max element 
//S.C : O(n * M * M), M = max element
class Solution {
    int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int MOD = (int) 1e9 + 7;

        int maxEl = -1;
        for (int num : nums) {
            maxEl = Math.max(maxEl, num);
        }

        int[][][] t = new int[n + 1][maxEl + 1][maxEl + 1];

        for (int first = 0; first <= maxEl; first++) {
            for (int second = 0; second <= maxEl; second++) {
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean gcdsMatch = (first == second);

                t[n][first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int first = maxEl; first >= 0; first--) {
                for (int second = maxEl; second >= 0; second--) {
                    int skip = t[i + 1][first][second];

                    int take1 = t[i + 1][gcd(first, nums[i])][second];

                    int take2 = t[i + 1][first][gcd(second, nums[i])];

                    t[i][first][second] = t[i][first][second] = (int) (((long) skip + take1 + take2) % MOD);
                }
            }
        }

        return t[0][0][0];
    }
}



//Approach-3 (Bottom Up - 2D DP, space optimized)
//T.C : O(n * M * M), M = max element
//S.C : O(M * M), M = max element
class Solution {
    int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int MOD = (int) 1e9 + 7;

        int maxEl = -1;
        for (int num : nums) {
            maxEl = Math.max(maxEl, num);
        }

        int[][] prev = new int[maxEl + 1][maxEl + 1];

        for (int first = 0; first <= maxEl; first++) {
            for (int second = 0; second <= maxEl; second++) {
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean gcdsMatch = (first == second);

                prev[first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[maxEl+1][maxEl+1];

            for (int first = maxEl; first >= 0; first--) {
                for (int second = maxEl; second >= 0; second--) {
                    int skip = prev[first][second];

                    int take1 = prev[gcd(first, nums[i])][second];

                    int take2 = prev[first][gcd(second, nums[i])];

                    curr[first][second] = curr[first][second] = (int) (((long) skip + take1 + take2) % MOD);
                }
            }
            prev = curr;
        }

        return prev[0][0];
    }
}