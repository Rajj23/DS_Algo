// T.C: O(nlogn)
// S.C: O(1)
class Solution {
    boolean isValid(int[] freq, int present){
        return freq[0] >= present && freq[1] >= present && freq[11] >= 2 * present &&
            freq[13] >= present && freq[14] >= 2 * present;

    }

    public int maxNumberOfBalloons(String text) {
        
        int[] freq = new int[26];

        for(char ch : text.toCharArray()){
            freq[ch - 'a']++;
        }

        int ans = 0;
        int l = 1, r = text.length();

        while(l <= r){
            int mid = l + (r-l)/2;
            if(isValid(freq, mid)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return ans;
    }
}