// Approach 1
// T.C : O(N)
// S.C : O(N)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count =0, preSum=0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,mp.getOrDefault(0,0)+1);
        for(int num:nums){
            preSum+= (num%2);
            int rem = preSum-k;
            count+=(mp.getOrDefault(rem,0));
            mp.put(preSum,mp.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}


// Approach 2
// T.C : O(N)
// S.C : O(1)
class Solution {
    int solve(int[] nums,int k){
        if(k<0){
            return 0;
        }
        int l=0,r=0,sum=0,cnt=0;
        while(r<nums.length){
            sum+=(nums[r]%2);
            while(sum>k){
                sum-=(nums[l]%2);
                l++;
            }
            cnt += (r-l+1);
            r++;
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k) - solve(nums,k-1);
    }
}