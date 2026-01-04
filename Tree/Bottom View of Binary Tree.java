// T.C: O(n)
// S.C: O(n)
class Solution {
    class Pair{
        Node node;
        int val;
        
        Pair(Node node, int val){
            this.node = node;
            this.val = val;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> mp = new TreeMap<>();
        
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair temp = q.poll();
            Node node = temp.node;
            int val = temp.val;
            
            mp.put(val,node.data);
            
            if(node.left != null) q.add(new Pair(node.left, val-1));
            
            if(node.right != null) q.add(new Pair(node.right, val+1));
        }
        
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            list.add(entry.getValue());
        }
        
        return list;
    }
}