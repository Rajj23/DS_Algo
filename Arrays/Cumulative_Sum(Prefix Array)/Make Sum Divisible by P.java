// T.C: O(2*N)
// S.C: O(N)
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int num:nums){
            sum = (sum+num)%p;
        }

        int target = sum%p;
        if(target==0){
            return 0;
        }

        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);

        int curr = 0;
        int result = n;
        for(int j=0;j<n;j++){
            curr = (curr+nums[j])%p;

            int remain = (curr-target+p)%p;
            if(mp.containsKey(remain)){
                result = Math.min(result,j-mp.get(remain));

            }
            mp.put(curr,j);
        }
        return result==n ? -1:result;
    }
}