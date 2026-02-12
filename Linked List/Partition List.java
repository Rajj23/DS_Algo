// T.C: O(n)
// S.C: O(1)
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode sm = new ListNode(0);
        ListNode small = sm;

        ListNode lm = new ListNode(0);
        ListNode large = lm;

        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }
            else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = lm.next;

        return sm.next;
    }
}