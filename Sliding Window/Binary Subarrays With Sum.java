// Approach 1
// T.C : O(N)
// S.C : O(N)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,mp.getOrDefault(0,0)+1);
        int preSum=0,cnt=0;

        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            int remove = preSum-goal;
            cnt+=mp.getOrDefault(remove,0);
            mp.put(preSum,mp.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
}


// Approach 2
// T.C : O(N)
// S.C : O(1)
class Solution {
    private int fun(int[] nums,int goal){
        int l=0,r=0,sum=0,cnt=0;
        if(goal<0) return 0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            cnt+= (r-l+1);
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cntZero = fun(nums,goal-1);
        int cntEqualLess = fun(nums,goal);

        return cntEqualLess - cntZero;
    }
}