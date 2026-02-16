// T.C: O(n)
// S.C: O(1)
class Solution {
    class Pair{
        Node node;
        int col;
        
        Pair(Node node, int col){
            this.node = node;
            this.col = col;
        }
    }
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        
        Queue<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair it = q.remove();
            
            int col = it.col;
            Node node = it.node;
            
            mp.computeIfAbsent(col, k -> new ArrayList<>()).add(node.data);
            
            if(node.left != null){
                q.add(new Pair(node.left, col-1));
            }
            
            if(node.right != null){
                q.add(new Pair(node.right, col+1));
            }
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry : mp.entrySet()){
            result.add(entry.getValue());
        }
        
        return result;
    }
}