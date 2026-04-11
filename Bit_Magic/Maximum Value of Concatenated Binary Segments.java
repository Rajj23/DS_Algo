// T.C: O(n log n * m + L) -> n = number of segments, m = maximum length of a segment
// S.C: O(L + n) -> L = total length of all segments combined
class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        int MOD = (int) 1e9+7;
        int n = nums1.length;
        
        String[] nums = new String[n];

        for(int i = 0; i < n; i++){
            int cnt1 = nums1[i];
            int cnt0 = nums0[i];

            StringBuilder sb = new StringBuilder();
            sb.append("1".repeat(cnt1));
            sb.append("0".repeat(cnt0));

            nums[i] = sb.toString();
        }

        Arrays.sort(nums, (a, b) -> (b+a).compareTo(a+b));

        int result = 0;
        for(String s : nums){
            for(char ch : s.toCharArray()){
                result = ((result << 1) + (ch - '0')) % MOD;
            }
        }

        return (int) result;
    }
}