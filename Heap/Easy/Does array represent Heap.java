// T.C : O(log*N)
// S.C : O(1)
class Solution {

    public boolean countSub(long arr[], long n) {
        // Your code goes here
        for(int i=0;i<n/2;i++){
            int left = i*2+1;
            int right = i*2+2;
            
            if(left<n && arr[i]<arr[left]){
                return false;
            }
            if(right<n && arr[i]<arr[right]){
                return false;
            }
        }
        return true;
    }
}