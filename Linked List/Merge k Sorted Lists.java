// T.C: O(n*log(n))
// S.C: O(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);

        for(ListNode list : lists){
            if(list != null)
                pq.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            head.next = temp;
            head = head.next;

            if(temp.next != null) pq.add(temp.next);

        }   

        head.next = null;

        return dummy.next;
    }
}