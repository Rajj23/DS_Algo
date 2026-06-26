//Approach- (Optimal Using Map) PART I Accepted, PART II TLE (Instead of map you can use an array of size 2*n+1 as well because we can have cumulative sum from -n to +n)
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int result = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int freq = 0;
            for(int j = i; j < n; j++){
                if(nums[j] == target){
                    freq++;
                }

                if(j-i+1 < 2*freq){
                    result++;
                }
            }
        }

        return result;
    }
}