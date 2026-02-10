//Approach (try all subarrays)
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            Set<Integer> oddSt = new HashSet<>();
            Set<Integer> evenSt = new HashSet<>();
            for(int j = i; j < n; j++){
                int num = nums[j];

                if(num % 2 == 0){
                    evenSt.add(num);
                }
                else{
                    oddSt.add(num);
                }

                if(oddSt.size() == evenSt.size()){
                    ans = Math.max(ans, (j-i+1));
                }
            }
        }

        return ans;
    }
}