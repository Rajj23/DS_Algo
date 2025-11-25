// T.C = O(2*(2*N))
// S.C = O(N*2)
class Solution {
    int func(int[] nums,int k){
        int l=0,r=0,cnt=0;
        Map<Integer,Integer> mp = new HashMap<>();

        while(r<nums.length){
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
            while(mp.size()>k){
                mp.put(nums[l],mp.get(nums[l])-1);
                if(mp.get(nums[l])==0){
                    mp.remove(nums[l]);
                }
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums,k) - func(nums,k-1);
    }
}