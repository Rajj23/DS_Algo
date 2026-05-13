// T.C: O(n)
// S.C: O(n)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        Stack<ListNode> st = new Stack<>();

        ListNode temp = head;
        int size = 0;
        while(temp != null){
            st.add(temp);
            temp = temp.next;
            size++;
        }

        temp = head;

        for(int i = 0; i < size/2; i++){
            ListNode nextNode = temp.next;
            ListNode lastNode = st.pop();

            temp.next = lastNode;
            lastNode.next = nextNode;

            temp = nextNode;
        }
        temp.next = null;
        
    }
}

// T.C: O(n)
// S.C: O(1)
class Solution {
    ListNode rev(ListNode node){
        if(node == null || node.next == null) return node;

        ListNode prev = null;
        ListNode next = null;

        while(node != null){
            ListNode nxt = node.next;
            node.next = prev;
            prev = node;
            node = nxt;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = rev(slow.next);
        slow.next = null;
        ListNode first = head;

        while(second != null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }
}