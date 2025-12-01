// T.C: O(log*n + n)
// S.C: O(n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int num:nums){
            pq.add(num);
        }

        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.poll();
    }
}