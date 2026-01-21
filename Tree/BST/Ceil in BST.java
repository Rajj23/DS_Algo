// T.C: O(log(n))
// S.C: O(1)
class Solution {
    int findCeil(Node root, int x) {
        // code here
        int ceil = -1;
        
        while(root != null){
            
            if(root.data == x){
                return root.data;
            }
            
            if(root.data < x){
                root = root.right;
            }
            else{
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}