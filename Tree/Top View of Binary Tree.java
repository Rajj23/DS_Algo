// T.C: O(n)
// S.C: O(n)
class Solution {
    class Pair{
        Node node;
        int col;
        
        public Pair(Node node, int col){
            this.node = node;
            this.col = col;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair it = q.remove();
            int col = it.col;
            Node temp = it.node;
            if(map.get(col)==null) map.put(col,temp.data);
            
            if(temp.left != null){
                q.add(new Pair(temp.left,col-1));
            }
            if(temp.right != null){
                q.add(new Pair(temp.right, col+1));
            }
        }
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
        
    }
}