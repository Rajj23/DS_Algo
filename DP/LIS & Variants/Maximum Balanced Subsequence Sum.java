//Approach-1 (Using LIS) - Recursion (TLE) ---> 316 / 345 testcases passed
//T.C : O(n^2) - prev index for every i
class Solution {
    Map<String, Long> mp;
    long solve(int prev, int idx, int[] nums){
        if(idx >= nums.length){
            return 0;
        }

        String key = prev + "_" + idx;
        if(mp.containsKey(key)){
            return mp.get(key);
        }

        long taken = Long.MIN_VALUE;
        long not_taken = Long.MIN_VALUE;

        if(prev == - 1 || nums[idx] - idx >= nums[prev] - prev){
            taken = nums[idx] + solve(idx, idx+1, nums);
        }

        not_taken = solve(prev, idx+1, nums);

        long value = Math.max(taken, not_taken);

        mp.put(key, value);

        return value;
    }

    public long maxBalancedSubsequenceSum(int[] nums) {
        long maxEle = Long.MIN_VALUE;
        for(int num : nums){
            maxEle = Math.max(maxEle, num);
        }
        if(maxEle <= 0) return maxEle;

        mp = new HashMap<>();

        return solve(-1, 0, nums);
    }
}

//Approach-2 (Using LIS Bottom Up) - TLE (341/345 Test cases passed)
//Time : O(n^2)
class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        long maxVal = Integer.MIN_VALUE;

        long[] t = new long[n];
        for(int i = 0; i < n; i++){
            t[i] = nums[i];
            maxVal = Math.max(maxVal, nums[i]);
        }

        if(maxVal <= 0) return maxVal;

        long maxSum = Long.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){

                if(nums[i] - i >= nums[j] - j){
                    t[i] = Math.max(t[i], t[j] + nums[i]);
                    maxSum = Math.max(maxSum, t[i]);
                }

            }
        }
        return maxSum > maxVal ? maxSum : maxVal;
    }
}


//Approach-3 (Using Optimal LIS - Similar to Patience Sorting) - Accepted
//Time : O(nlogn)
class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;

        TreeMap<Integer, Long> mp = new TreeMap<>();

        long result = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(nums[i] <= 0){
                result = Math.max(result, nums[i]);
                continue;
            }

            long temp = nums[i];
            if(mp.floorKey(nums[i] - i) != null){
                temp += mp.get(mp.floorKey(nums[i] - i));
            }

            while(mp.ceilingKey(nums[i] - i) != null && 
                mp.get(mp.ceilingKey(nums[i] - i)) < temp){
                    mp.remove(mp.ceilingKey(nums[i] - i));
                }        

            if(mp.floorKey(nums[i] - i) == null || mp.get(mp.floorKey(nums[i] - i)) < temp){
                    mp.put(nums[i] - i, temp);
                }
            
            result = Math.max(result, temp);
        }
        return result;
    }
}