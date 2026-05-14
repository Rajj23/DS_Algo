// T.C: O(n)
// S.C: O(n)
class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        if(n == 1) return false;

        int[] vis = new int[n];
        for(int i = 0; i < n; i++){
            int num = nums[i];
            if(num >= n) return false;
            vis[num]++;
        }

        for(int i = 1; i < n-1; i++){
            if(vis[i] != 1) return false;
        }

        if(vis[n-1] != 2) return false;
        
        return true;
    }
}

// T.C: O(n(log(n)))
// S.C: O(n)
class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        if(n == 1) return false;

        Arrays.sort(nums);
        for(int i = 1; i < n; i++){
            if(i != nums[i-1]) return false;
        }

        if(nums[n-1] != nums[n-2]) return false;
        
        return true;
    }
}