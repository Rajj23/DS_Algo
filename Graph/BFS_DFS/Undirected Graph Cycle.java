class Solution {
    boolean DFS(List<List<Integer>> adj, int u, boolean[] visited, int parent){
        
        visited[u] = true;
        for(int v : adj.get(u)){
            if(v == parent) continue;
            
            if(visited[v]) return true;
            
            
            if(DFS(adj, v, visited, u)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        boolean[] visited = new boolean[V];
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        for(int i = 0; i < V; i++){
            if(visited[i] != true && DFS(adj, i, visited, -1)){
                return true;
            }
        }
        
        return false;
    }
}