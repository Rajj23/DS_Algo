// Approach: 1 
// T.C: O(n^2)
// S.C: O(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;

        for(int i = 0; i < n-2; i++){

            Set<Integer> seen = new HashSet<>();

            for(int j = i+1; j < n; j++){
                int c = -(nums[i] + nums[j]);
                if(seen.contains(c)){
                    List<Integer> triplet = Arrays.asList(nums[i], c, nums[j]);
                    Collections.sort(triplet);
                    st.add(triplet);
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(st);
    }
}

// Approach: 2
// T.C: O(n log(n))
// S.C: O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;

        for(int i = 0; i < n-2; i++){

            int l = i + 1, r = n-1;
            int tar = -nums[i];
            while(l < r){
                if(nums[l] + nums[r] == tar){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[l], nums[r]);
                    Collections.sort(triplet);
                    st.add(new ArrayList<>(triplet));
                    l++;
                    r--;
                }
                else if(nums[l] + nums[r] > tar){
                    r--;
                }
                else{
                    l++;
                }
            }

        }

        return new ArrayList<>(st);
    }
}