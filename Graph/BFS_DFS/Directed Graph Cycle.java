// Approach: Build adjacency list and run DFS using a recursion stack (inRecursion).
// If we reach a node already in the current recursion stack, a cycle exists.
// Time: O(V + E)
// Space: O(V + E)
class Solution {
    private boolean isCycleDFS(List<List<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion){
        visited[u] = true;
        inRecursion[u] = true;
        
        for(int v : adj.get(u)){
            if(visited[v] == false && isCycleDFS(adj, v, visited, inRecursion)){
                return true;
            }
            else if(inRecursion[v] == true){
                return true;
            }
        }
        
        inRecursion[u] = false;
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i] && isCycleDFS(adj, i, visited, inRecursion)){
                return true;
            }
        }
        return false;
    }
}