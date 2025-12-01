// T.C: O(n * log n)
// S.C: O(1)
class Solution {
    boolean possible(int[] batteries, long mid,int n){
        long target = n * mid;


        for(int i=0;i<batteries.length;i++){
            target-=Math.min(batteries[i],mid);

            if(0>=target){
                return true;
            }
        }
        return false;
    }
    public long maxRunTime(int n, int[] batteries) {
        long l=Long.MAX_VALUE,r=0,sum=0;
        for(int batterie:batteries){
            l = Math.min(l,batterie);
            sum+=batterie;
        }
        r = sum/n;

        long result = 0;

        while(l <=r){
            long mid = l + (r-l)/2;

            if(possible(batteries,mid,n)){
                result = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return result;
    }
}