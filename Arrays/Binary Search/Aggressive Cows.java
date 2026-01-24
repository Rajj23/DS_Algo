// T.C: O(n*log(n))
// S.C: O(1)
class Solution {
    boolean isValid(int[] stalls, int dis, int k){
        int currCow = 1;
        int lastPos = stalls[0];
        
        int n = stalls.length;
        
        for(int i = 1; i < n; i++){
            if(stalls[i] - lastPos >= dis){
                currCow++;
                lastPos = stalls[i];
            }
            
        }
        
        return currCow >= k;
    }
    
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        
        int n = stalls.length;
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        
        
        int ans = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(isValid(stalls, mid, k)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            
        }
        return ans;
    }
}