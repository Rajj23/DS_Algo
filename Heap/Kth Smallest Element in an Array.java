// T.C: O(log*n + n)
// S.C: O(n)
class Solution {
    public int kthSmallest(int[] nums, int k) {
        // Code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num:nums){
            pq.add(num);
        }
        
        for(int i=1;i<k;i++){
            pq.poll();
        }
        
        return pq.poll();
    }
}
