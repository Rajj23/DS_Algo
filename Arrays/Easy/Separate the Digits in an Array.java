// T.C: O(n*log(n))
// S.C: O(n*log(n))
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            List<Integer> temp = new ArrayList<>();
            while(num > 0){
                int digit = num%10;
                num /= 10;
                temp.add(digit);
            }
            Collections.reverse(temp);
            list.addAll(temp);
        }
        int n = list.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}