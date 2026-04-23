//Approach (Using prefix sum and map)
// T.C: O(n)
// S.C: O(n)
class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, long[]> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            long[] arr = mp.computeIfAbsent(nums[i], k-> new long[4]);
            arr[2] += 1;
            arr[3] += i;
        }


        long[] ans = new long[n];
        for(int i = 0; i < n; i++){
            int key = nums[i];

            long[] arr = mp.get(key);

            arr[3] -= i;
            arr[2] -= 1;

            ans[i] = ((arr[0] * i) - arr[1]) + (arr[3] - (arr[2] * i));

            arr[0] += 1;
            arr[1] += i;
        }

        return ans;
    }
}