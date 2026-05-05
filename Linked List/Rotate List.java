// T.C: O(2n)
// S.C: O(1)
class Solution {
    ListNode rev(ListNode head){
        ListNode prev = null;
        ListNode nxt = null;

        while(head != null){
            nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            n++;
        }

        k %= n;
        if(k == 0) return head;

        ListNode revHead = rev(head);
        curr = revHead;
        for(int i = 0; i < k-1; i++){
            curr = curr.next;
        }
        
        ListNode second = curr.next;
        curr.next = null;

        ListNode temp1 = rev(revHead);
        ListNode temp2 = rev(second);
        
        ListNode temp = temp1;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = temp2;

        return temp1;
    }
}


// T.C: O(2n)
// S.C: O(1)
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int n = 1;        
        ListNode temp = head;

        while(temp.next != null){
            temp = temp.next;
            n++;
        }
        k %= n;
    
        temp.next = head;

        for(int i = 0; i < n-k-1; i++){
            head = head.next;
        }
        temp = head.next;
        head.next = null;

        return temp;
    }
}
