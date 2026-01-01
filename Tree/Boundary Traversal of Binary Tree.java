// T.C: O(2n + h)
// S.C: O(n)
class Solution {
    boolean isLeaf(Node root){
        return root.left == null && root.right==null;
    }
    
    void addLeftBoundary(Node root, ArrayList<Integer> result){
        Node curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr)){
                result.add(curr.data);
            }
            
            if(curr.left!=null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
    }
        
    void addRightBoundary(Node root, ArrayList<Integer> result){
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(curr != null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            
            if(curr.right != null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        
        for(int i=temp.size()-1; i>=0 ;i--){
            result.add(temp.get(i));
        }
    }
    
    void addLeaves(Node root, List<Integer> result){
        if(isLeaf(root)){
            result.add(root.data);
            return;
        }
        
        if(root.left != null){
            addLeaves(root.left,result);
        }
        if(root.right != null){
            addLeaves(root.right,result);
        }
    }
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null) return result;
        
        if(!isLeaf(root)){
            result.add(root.data);
        }
        
        addLeftBoundary(root,result);
        addLeaves(root,result);
        addRightBoundary(root,result);
        
        return result;
    }
}