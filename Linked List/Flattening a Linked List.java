// T.C: O(n)
// S.C: O(1)
class Solution {

    Node flatten(Node root) {

        if (root == null) return null;

        Node curr = root;

        while (curr.next != null) {

            Node a = curr;
            Node b = curr.next;

            Node dummy = new Node(-1);
            Node tail = dummy;

            Node p = a;
            Node q = b;

            while (p != null && q != null) {
                if (p.data <= q.data) {
                    tail.bottom = p;
                    p = p.bottom;
                } else {
                    tail.bottom = q;
                    q = q.bottom;
                }
                tail = tail.bottom;
            }

            if (p != null) tail.bottom = p;
            else tail.bottom = q;

            curr = dummy.bottom;
            curr.next = b.next;
        }

        return curr;
    }
}
