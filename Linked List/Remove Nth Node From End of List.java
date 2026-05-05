// Approach: Count list size
// T.C: O(2n)
// S.C: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode temp = head;

        int n = 0;
        while(temp != null){
            n++;
            temp = temp.next;
        }

        int i = 0;
        temp = head;

        if(n==k) return head.next;
        while(i < n-k-1){
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;

        return head;
    }
}

// Approach: Slow-fast
// T.C: O(n)
// S.C: O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast != null && n >= 0){
            fast = fast.next;
            n--;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;

        return dummy.next;
    }
}