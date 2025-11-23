// Approach 1
// T.C : O(N)
// S.C : O(N)
class Solution {
    int solve(int[] nums,int i, int rem,int[][] t){
        if(i>=nums.length){
            if(rem==0){
                return 0;
            }
            return Integer.MIN_VALUE;
        }

        if(t[i][rem] !=-1){
            return t[i][rem];
        }

        int pick = nums[i] + solve(nums,i+1,(rem+nums[i])%3,t);
        int notPick = solve(nums,i+1,rem,t);

        t[i][rem] = Math.max(pick,notPick);

        return t[i][rem];
    }
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] t = new int[n][3];

        for(int i=0;i<n;i++){
            Arrays.fill(t[i],-1);
        }

        return solve(nums,0,0,t);
    }
}

// Approach 2
// T.C : O(N)
// S.C : O(N)
class Solution {
    public int maxSumDivThree(int[] nums){
        int n = nums.length;
        int[][] t = new int[n+1][3];

        for(int i=0;i<n;i++){
            Arrays.fill(t[i],Integer.MIN_VALUE);
        }

        t[n][0] = 0;
        t[n][1] = Integer.MIN_VALUE;
        t[n][2] = Integer.MIN_VALUE;

        for(int i=n-1;i>=0;i--){
            for(int rem=0;rem<=2;rem++){

                int newRemain = (rem + nums[i]) %3;
                int take = (t[i+1][newRemain]==Integer.MIN_VALUE) ? Integer.MIN_VALUE : nums[i] + t[i+1][newRemain];

                int skip = t[i+1][rem];

                t[i][rem] = Math.max(take,skip);
            }
        }

        return t[0][0];
    }
}


// Approach 3
// T.C : O(N*log*N)
// S.C : O(2*N)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum =0;
        List<Integer> remain1 = new ArrayList<>();
        List<Integer> remain2 = new ArrayList<>();

        for(int num:nums){
            sum+=num;

            if(num%3==1){
                remain1.add(num);
            }
            else if(num%3==2){
                remain2.add(num);
            }
        }

        if(sum%3==0) return sum;

        Collections.sort(remain1);
        Collections.sort(remain2);

        int result = 0;

        int remainder = sum%3;
        if(remainder==1){
            int remove1 = remain1.size() >=1 ? remain1.get(0) : Integer.MAX_VALUE;
            int remove2 = remain2.size() >=2 ? remain2.get(0)+remain2.get(1) : Integer.MAX_VALUE;

            result = Math.max(result, sum-Math.min(remove1,remove2));
        }
        else{
            int remove1 = remain2.size() >=1 ? remain2.get(0) : Integer.MAX_VALUE;
            int remove2 = remain1.size() >=2 ? remain1.get(0)+remain1.get(1) : Integer.MAX_VALUE;

            result = Math.max(result, sum-Math.min(remove1,remove2));
        }

        return result;
    }
}