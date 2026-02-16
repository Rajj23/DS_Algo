// T.C: O(n)
// S.C: O(1)
class Solution {
    void left(Node root, int level, ArrayList<Integer> result){
        if(root == null) return;
        
        if(result.size() == level){
            result.add(root.data);
        }
        
          
            left(root.left, level+1,  result);
      
            left(root.right, level+1, result);
        
    }
    public ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        
        if(root == null) return result;
        
        left(root, 0, result);
        
        return result;
    }
}