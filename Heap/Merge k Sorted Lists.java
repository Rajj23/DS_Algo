/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


// Approach 1
// T.C: O(N*log*N)
// S.C: O(N)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = lists.length;
        for(int i=0;i<n;i++){
            ListNode node = lists[i];
            while(node!=null){
                pq.add(node.val);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            temp.next = new ListNode(pq.poll());
            temp = temp.next;
        }
        return dummy.next;
    }
}

// Approach 2
// T.C: O(N*log*k)
// S.C: O(N)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b)->a.val - b.val);

        for(ListNode node:lists){
            if(node != null){
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;

            if(node.next != null){
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}