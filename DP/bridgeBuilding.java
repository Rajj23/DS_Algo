
class Main {
    static int bridgeBuilding(int[][] nums){
        Arrays.sort(nums, (a,b)->{
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        int n = nums.length;
        
        int ans = 0;
        
        // dp creation
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i][1] >= nums[j][1]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        ans = Math.max(ans, dp[i]);
                    }
                }
            }
        }
        
        return ans;
        
    }
    public static void main(String[] args) {
        int[][] nums = {
            {8,1},
            {1,2},
            {4,3},
            {3,4},
            {5,5},
            {2,6},
            {6,7},
            {7,8}
        };
        
        System.out.println(bridgeBuilding(nums));
    }
}