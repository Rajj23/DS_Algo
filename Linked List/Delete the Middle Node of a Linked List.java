// Approach: Count size then remove middle
// T.C: O(n)
// S.C: O(1)
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        int n = 0;

        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            n++;
        }

        curr = head;
        int idx = 0;
        while(curr != null && idx < n/2-1){
            idx++;
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }
}



// Approach 2: Slow - Fast technique
// T.C: O(n)
// S.C: O(1)
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(slow != null && fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = prev.next.next;

        return head;
    }
}