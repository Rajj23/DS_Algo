// Approach 1
// T.C : O(N)
// S.C : O(N) 
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> st = new HashSet<>();
        for(int num:nums){
            st.add(num);
        }

        while(st.contains(original)){
            original*=2;
        }

        return original;
    }
}


// Approach 2
// T.C : O(N*log(N))
// S.C : O(1) 
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for(int num:nums){
            if(num==original){
                original *=2;
            }
        }

        return original;
    }
}