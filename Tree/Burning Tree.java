// T.C: O(2n)
// S.C: O(n)
class Solution {
    Node targetNode;
    
    private void markParent(Map<Node, Node> parentMap, Node root, int target){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.data == target){
                targetNode = curr;
            }
            
            if(curr.left != null){
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }
            
            if(curr.right != null){
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
    
    public int minTime(Node root, int target) {
        // code here
        Map<Node, Node> parentMap = new HashMap<>();
        markParent(parentMap, root, target);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);
        visited.put(targetNode, true);
        
        int timeTaken = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean burned = false;
            
            
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    q.add(curr.left);
                    visited.put(curr.left, true);
                    burned = true;
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    q.add(curr.right);
                    visited.put(curr.right, true);
                    burned = true;
                }
                if(parentMap.get(curr) != null && visited.get(parentMap.get(curr)) == null){
                    q.add(parentMap.get(curr));
                    visited.put(parentMap.get(curr), true);
                    burned = true;
                }
            }
            if(burned){
                timeTaken++;
            }
        }
        
        return timeTaken;
    }
}