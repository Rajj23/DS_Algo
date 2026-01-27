// T.C: O(2*log(n))
// S.C: O(1)
class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node predecessor = null;
        Node successor = null;
        
        Node curr = root;
        while(curr != null){
            if(curr.data >= key){
                curr = curr.left;
            }
            else{
                predecessor = curr;
                curr = curr.right;
            }
        }
        
        curr = root;
        while(curr != null){
            if(curr.data <= key){
                curr = curr.right;
            }
            else{
                successor = curr;
                curr = curr.left;
            }
        }
        
        ArrayList<Node> result = new ArrayList<>();
        result.add(predecessor);
        result.add(successor);
        
        return result;
    }
}