// Approach: Recursion
// T.C: O(2^n)
// S.C: O(1)
class Solution {
    int solve(int i, int prev, int[] nums){
        if(i == nums.length) return 0;

        int pick = 0;
        if(nums[i] > prev){
            pick = 1 + solve(i+1, nums[i], nums);
        }

        int notPick = solve(i+1, prev, nums);

        return Math.max(pick, notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, solve(i, Integer.MIN_VALUE, nums));
        }        

        return max;
    }
}



// T.C: O(n*n)
// S.C: O(n)
class Solution{
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] t = new int[n];

        Arrays.fill(t, 1);

        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    t[i] = Math.max(t[i], t[j]+1);
                }
            }
            ans = Math.max(ans, t[i]);
        }

        return ans;
    }
}

//Approach-1 (TopDown: Recur+Memo) 
//T.C : O(n*n)
//S.C : O(n*n)
class Solution {
    int[][] t;
    final int OFFSET = 10001;
    int solve(int idx, int[] nums, int prev){
        if(idx == nums.length) return 0;

        // int prevIdx = OFFSET + prev;

        if(t[idx][prev] != Integer.MIN_VALUE){
            return t[idx][prev];
        }
        
        int n = nums.length;

        int take = 0;

        if(prev == n || nums[idx] > nums[prev]){
            take = 1 + solve(idx+1, nums, idx);
        }

        int skip = solve(idx+1, nums, prev);

        return t[idx][prev] = Math.max(take, skip);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        t = new int[n][n+1];

        for(int i = 0; i < n; i++){
            Arrays.fill(t[i], Integer.MIN_VALUE);
        }

        return solve(0, nums, n);
    }
}


//Approach-4 (Using concept of Patience Sorting (O(nlogn))
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    int binarySearch(List<Integer> sorted, int tar){
        int l = 0, r = sorted.size() - 1;

        while(l <= r){
            int mid = l + (r-l) / 2;

            if(sorted.get(mid) < tar){
                l = mid+1;
            }
            else{
                r = mid - 1;
            }
        }
        return l;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int it = binarySearch(sorted, nums[i]);

            if(it == sorted.size()){
                sorted.add(nums[i]);
            }
            else{
                sorted.set(it, nums[i]);
            }
        }

        return sorted.size();
    }
}