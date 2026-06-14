// T.C: O(n)
// S.C: O(1)
class Solution {
    ListNode getReversed(ListNode node){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = node;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public int pairSum(ListNode head) {
        ListNode dummy = head;

        ListNode fast = head;
        ListNode slow = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = getReversed(slow);

        int result = Integer.MIN_VALUE;

        ListNode node1 = head;
        ListNode node2 = reversed;

        while(node1 != null && node2 != null){
            int sum = node1.val + node2.val;
            result = Math.max(result, sum);

            node1 = node1.next;
            node2 = node2.next;
        }   

        return result;
    }
}