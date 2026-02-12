// T.C: O(n)
// S.C: O(1)
class Solution {
    // Function to find the data of kth node from
    // the end of a linked list.
    int getKthFromLast(Node head, int k) {
        // Your code here
        Node start = head;
        Node end = head;
        
        while(start != null && k > 0){
            start = start.next;
            k--;
        }
        
        if(k > 0) return -1;
        
        while(start != null){
            end = end.next;
            start = start.next;
        }
        
        return end.data;
    }
}