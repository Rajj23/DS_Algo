// T.C: O(2n + logn)
// S.C: O(2n)
class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        // code here
        HashMap<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            mp.put(arr[i],i);
            pq.add(arr[i]);
        }
        
        for(int i=0;i<n;i++){
            int ele = pq.poll();
            int val = mp.get(ele);
            if(Math.abs(val-i)>k){
                return "No";
            }
        }
        return "Yes";
    }
}