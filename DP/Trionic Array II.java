// T.C: O(n)
// S.C: O(n)
class Solution {
    int n;
    long[][] t;
    long solve(int i, int trend, int[] nums){
        if(i == n){
            if(trend == 3){
                return 0;
            }

            return Long.MIN_VALUE/2;
        }

        if(t[i][trend] != Long.MIN_VALUE) return t[i][trend];

        long take = Long.MIN_VALUE/2;
        long skip = Long.MIN_VALUE/2;

        if(trend == 0){
            skip = solve(i+1, trend, nums);
        }

        if(trend == 3){
            take = nums[i];
        }

        if(i+1 < n){
            int curr = nums[i];
            int next = nums[i+1];

            if(trend == 0 && next > curr){
                take = Math.max(take, curr + solve(i+1, 1, nums));
            }
            else if(trend == 1){
                if(next > curr){
                    take = Math.max(take, curr + solve(i+1, 1, nums));
                }
                else if(next < curr){
                    take = Math.max(take, curr + solve(i+1, 2, nums));
                }
            }
            else if(trend == 2){
                if(next < curr){
                    take = Math.max(take, curr + solve(i+1, 2, nums));
                }
                else if(next > curr){
                    take = Math.max(take, curr + solve(i+1, 3, nums));
                }
            }
            else if(trend == 3 && next > curr){
                take = Math.max(take, curr + solve(i+1, 3, nums));
            }
        }

        return t[i][trend] = Math.max(take, skip);
    }

    public long maxSumTrionic(int[] nums) {
        n = nums.length;
        t = new long[n+1][4];
        for(int i = 0; i < n; i++){
            Arrays.fill(t[i], Long.MIN_VALUE);
        }
        return solve(0, 0, nums);
    }
}