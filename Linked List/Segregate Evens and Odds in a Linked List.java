// T.C: O(n)
// S.C: O(1)
class Solution {
    Node divide(Node head) {
        // code here
        Node e = new Node(0);
        Node o = new Node(0);
        
        Node odd = o;
        Node even = e;
        
        while(head != null){
            if(head.data % 2 == 0){
                even.next = head;
                even = even.next;
            }
            else{
                odd.next = head;
                odd = odd.next;
            }
            
            head = head.next;
        }
        odd.next = null;
        even.next = o.next;
        
        return e.next;
    }
}