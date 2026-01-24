// Approach: 1(sorting and then finding the h index)
// T.C: O(n*log(n))
// S.C: O(1)
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        int low = 0;
        int high = n - 1;
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low)/2;
            int h = n - mid;
            if(citations[mid] >= h){
                ans = h;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}


// Approach: 2(bucket sort)
// T.C: O(n)
// S.C: O(n)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int[] freq = new int[n+1];

        for(int i = 0; i < n; i++){
            int citation = Math.min(citations[i],n);

            freq[citation]++;
        }

        int currCitation = 0;
        for(int i = n; i >= 0; i--){
            currCitation += freq[i];

            if(currCitation >= i){
                return i;
            }
        }
        return -1;
    }
}