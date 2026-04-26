// T.C: O(n)
// S.C: O(n)
class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0] = nums[0];
        suf[n-1] = nums[n-1];
        for(int i = 1; i < n; i++){
            pre[i] = Math.max(pre[i-1], nums[i]);
        }

        for(int i = n-2; i >= 0; i--){
            suf[i] = Math.max(suf[i+1], nums[i]);
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        if(n == 1) return list;
        
        for(int i = 1; i < n-1; i++){
            if(nums[i] > pre[i-1] || nums[i] > suf[i+1]){
                list.add(nums[i]);
            }
        }
        list.add(nums[n-1]);

        return list;
    }
}