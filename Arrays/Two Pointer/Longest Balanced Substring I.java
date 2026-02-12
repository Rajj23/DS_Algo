//Approach (try all subarrays)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
    public int longestBalanced(String s) {
        int maxLen = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            int[] freq = new int[26];

            for(int j = i; j < n; j++){

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                
                freq[s.charAt(j)-'a']++;

                for(int num : freq){
                    if(num != 0){
                        min = Math.min(min, num);
                        max = Math.max(max, num);
                    }
                }

                if(min == max) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }

        return maxLen;
    }
}