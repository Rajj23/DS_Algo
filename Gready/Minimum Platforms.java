// Approach 1
// T.C: O(nlogn + n)
// S.C: O(2n + p)
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int n = arr.length;
        int[][] pair = new int[n][2];
        
        for(int i=0;i<n;i++){
            pair[i][0] = arr[i];
            pair[i][1] = dep[i];
        }
        
        Arrays.sort(pair,(a,b)->{
            if(a[0]==b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(pair[0][1]);
        
        for(int i=1;i<n;i++){
            if(pq.peek()>=pair[i][0]){
                pq.add(pair[i][1]);
            }
            else{
               pq.poll();
               pq.add(pair[i][1]);
            }
        }
        
        return pq.size();
    }
}



// Approach 2
// T.C: O(nlogn + 2n)
// S.C: O(1)
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int maxPlat = 1, currPlat=1;
        int i=1,j=0;
        int n = arr.length;
        
        while(i < n && j<n){
            if(arr[i]<=dep[j]){
                currPlat++;
                i++;
            }
            else{
                currPlat--;
                j++;
            }
            maxPlat = Math.max(maxPlat,currPlat);
        }
        return maxPlat;
    }
}
