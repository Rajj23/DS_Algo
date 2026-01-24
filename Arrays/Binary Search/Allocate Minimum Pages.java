// T.C: O(n*log(n))
// S.C: O(1)
class Solution {
    boolean possible(int[] arr, int pages, int k){
        int stud = 1;
        int page = 0;
        
        for(int a : arr){
            if(page+a > pages){
                stud++;
                page = a;
            }
            else{
                page += a;
            }
        }
        return stud <= k;
    }
    public int findPages(int[] arr, int k) {
        // code here
        int n  = arr.length;
        
        if(k > n) return -1;
        
        int low = 0;
        int high = 0;
        
        int ans = -1;
        for(int a : arr){
            low = Math.max(low, a);
            high += a;
        }
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(possible(arr, mid,k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}