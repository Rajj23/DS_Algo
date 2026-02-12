// T.C: O(n)
// S.C: O(1)
class Solution {
    ListNode reverse(ListNode head, int k){

        ListNode prev = null;
        ListNode Next = null;

        while(head != null && k > 0){
            Next = head.next;
            head.next = prev;
            prev = head;
            head = Next;
            k--;
        }

        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;


        ListNode prev = dummy;
        ListNode temp = head;

        while(temp != null){
            ListNode Next = temp;
            int n = 0;

            while(Next != null && n < k){
                Next = Next.next;
                n++;
            }

            if(n < k) break;

            ListNode newHead = reverse(temp, k);

            prev.next = newHead;
            temp.next = Next;

            prev = temp;
            temp = Next;
        }

        return dummy.next;

    }
}