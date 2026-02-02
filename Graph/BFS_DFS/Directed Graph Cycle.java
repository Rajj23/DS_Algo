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


// Time: O(V + E)
// Space: O(V + E)
class Solution {
    public boolean isCyclic(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
        }
        
        int[] indegree = new int[V];
        
        for(int u = 0; u < V; u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
        
        while(!q.isEmpty()){
            int u = q.poll();
            count++;
            
            for(int e : adj.get(u)){
                indegree[e]--;
                
                if(indegree[e] == 0){
                    q.add(e);
                }
            }
        }
        
        return count != V;
    }
}