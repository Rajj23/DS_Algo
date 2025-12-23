// Approach 1
// T.C: O(n*logn)
// S.C: O(3n)
class Solution {
    int n;
    int t[][];
    int binarySearch(int[][] events,int endTime){
        int l=0;
        int r=n-1;
        int result = n;

        while(l<=r){
            int mid = l +(r-l)/2;

            if(events[mid][0] > endTime){
                result = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return result;
    }
    int solve(int[][] events,int i,int count){
        if(count==2 || i>=n){
            return 0;
        }

        if(t[i][count] != -1){
            return t[i][count];
        }

        int nextValidEventsIndex = binarySearch(events,events[i][1]);
        int take = events[i][2] + solve(events,nextValidEventsIndex,count+1);

        int notTake = solve(events,i+1,count);

        return t[i][count] = Math.max(take,notTake);
    }
    public int maxTwoEvents(int[][] events) {
        n = events.length;
        t = new int[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(t[i],-1);
        }
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int count = 0;
        return solve(events,0,count);
    }
}
