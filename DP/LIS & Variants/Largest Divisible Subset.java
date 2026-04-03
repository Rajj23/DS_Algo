//Approach-` (Using Rec + Memo same as LIS) - Just need to keep track of how to print LIS
//T.C : O(n^2)
//S.C : O(n^2)
class Solution {
    int[][] t;
    boolean[][] choice;
    int solve(int idx, int[] nums, int prev){
        int n = nums.length;
        if(idx == nums.length){
            return 0;
        }

        if(t[idx][prev+1] != -1) return t[idx][prev+1];

        int pick = 0;
        if(prev == -1 || nums[idx] % nums[prev] == 0){
            pick = 1 + solve(idx+1, nums, idx);
        }

        int notPick = solve(idx+1, nums, prev);

        if(pick > notPick){
            choice[idx][prev+1] = true;
            return t[idx][prev+1] = pick;
        }
        else{
            choice[idx][prev+1] = false;
            return t[idx][prev+1] = notPick;
        }
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        t = new int[n][n+1];
        choice = new boolean[n][n+1];

        for(int i = 0; i < n; i++){
            Arrays.fill(t[i], -1);
        }

        List<Integer> result = new ArrayList<>();
        solve(0, nums, -1 );  

        int prev = -1;
        for(int i = 0; i < n; i++){
            if(choice[i][prev+1]){
                result.add(nums[i]);
                prev = i;
            }
        }  

        return result;
    }
}



//Approach-2 (Using Bottom Up same as LIS) - Just need to keep track of how to print LIS
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] t = new int[n];
        int[] prev = new int[n];
        Arrays.fill(t, 1);
        Arrays.fill(prev, -1);

        int maxIdx = 0;
        int maxL = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && t[j]+1 > t[i]){
                    prev[i] = j;
                    t[i] = t[j] + 1;

                    if(t[i] > maxL){
                        maxL = t[i];
                        maxIdx = i;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int idx = maxIdx;
        while(idx >= 0){
           result.add(nums[idx]);
           idx = prev[idx];
        }
        Collections.reverse(result);
        return result;
    }
}