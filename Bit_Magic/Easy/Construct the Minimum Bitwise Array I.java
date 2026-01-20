// Approach: 1
// T.C: O(n * m)
// S.C: O(1)
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        for(int j = 0; j < n; j++){
            int num = nums.get(j);
            
            boolean found = false;
            for(int i = 1; i < num; i++){
                if((i | (i+1)) == num){
                    ans[j] = i;
                    found = true;
                    break;
                }
            }

            if(!found){
                ans[j] = -1;
            }

        }

        return ans;
    }
}

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