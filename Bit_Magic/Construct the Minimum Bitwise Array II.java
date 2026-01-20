// Approach: 2
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();

        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            if(nums.get(i) == 2){
                result[i] = -1;
                continue;
            }
            boolean found = false;

            for(int j = 1; j < 32; j++){
                if((nums.get(i) & (1 << j)) > 0){
                    continue;
                }
                
                int prev = j-1;
                int x = (nums.get(i) ^ (1 << (j-1)));
                result[i] = x;
                found = true;
                break;
            }

            if(!found){
                result[i] = -1;
            }
        }
        return result;
    }
}