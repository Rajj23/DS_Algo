// T.C: O(n)
// S.C: O(n)
class Solution {
    public static int subArraySum(int[] arr, int k) {
        // code here.
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int ans = 0;
        
        map.put(0, 1);
        
        for(int num : arr){
            sum += num;
            
            if(map.containsKey(sum - k)){
                ans += map.get(sum-k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        
        return ans;
    }
}
