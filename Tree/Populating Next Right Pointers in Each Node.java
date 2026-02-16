// T.C: O(n)
// S.C: O(1)
class Solution {
    public Node connect(Node root) {
        Node node = root;

        while(node != null && node.left != null){
            Node curr = node;

            while(true){
                curr.left.next = curr.right;

                if(curr.next == null) break;

                curr.right.next = curr.next.left;
                curr = curr.next;
            }
            node = node.left;
        }

        return root;
    }
}