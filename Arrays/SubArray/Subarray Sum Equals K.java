// Approach: Brute Force
// T.C: O(n*n)
// S.C: O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum == k){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}


// Approach: Prefix sum + HashMap
// T.C : O(N)
// S.C : O(N)
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,mp.getOrDefault(0,0)+1);
        int preSum=0,cnt=0;

        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            int remove = preSum-k;
            cnt+=mp.getOrDefault(remove,0);
            mp.put(preSum,mp.getOrDefault(preSum,0)+1);
        }
        return cnt;
    }
}