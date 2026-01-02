// Approach 1
// T.C: O(nlogn)
// S.C: O(1)
class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}

// Approach 2
// T.C: O(2n)
// S.C: O(n)
class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int m = nums.length;
        int n = m/2;
        
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if(entry.getValue()==n){
                return entry.getKey();
            }
        }
        return -1;
    }
}

// Approach 3
// T.C: O(n)
// S.C: O(n)
class Solution {
    public int repeatedNTimes(int[] nums){
        Set<Integer> st = new HashSet<>();

        for(int num:nums){
            if(st.contains(num)){
                return num;
            }
            else{
                st.add(num);
            }
        }
        return -1;
    }
}


// Approach 4
// T.C: O(n)
// S.C: O(1)
class Solution {
    public int repeatedNTimes(int[] nums) {
        for(int i=2;i<nums.length;i++){
            if(nums[i]==nums[i-1] || nums[i]==nums[i-2]){
                return nums[i];
            }
        }

        return nums[0];
    }
}