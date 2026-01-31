// T.C: O(V+E)
// S.C: O(V)
class Solution {
    
    void BFS(int u, boolean[] visited, List<List<Integer>> adj, ArrayList<ArrayList<Integer>> result){
        ArrayList<Integer> list = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        visited[u] = true;
        q.add(u);
        
        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);
            
            for(int v : adj.get(node)){
                if(!visited[v]){
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        
        result.add(list);
    }
    
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                BFS(i, visited, adj, result);
            }
        }
        
        return result;
    }
}