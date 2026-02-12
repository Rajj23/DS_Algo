// Approach: Iterative
// T.C: O(n)
// S.C: O(1)
class Solution {
    public ListNode reverseList(ListNode curr) {
        ListNode prev = null;
        ListNode Next = null;

        while(curr != null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }

        return prev;
    }
}


// Approach: Iterative
// T.C: O(n)
// S.C: O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);

        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
}