// DFS-based cycle detection in an undirected graph
// Time Complexity: O(V + E) for building the adjacency list and DFS traversal
// Space Complexity: O(V + E) for the adjacency list and recursion stack (O(V) in worst case)
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



// BFS-based cycle detection in an undirected graph
// Time Complexity: O(V + E) for building the adjacency list and BFS traversal
// Space Complexity: O(V + E) for the adjacency list and queue (O(V) in worst case)
class Solution {
    boolean isCycleBFS(List<List<Integer>> adj, int u, boolean[] visited){
        Queue<int[]> que = new LinkedList<>();
        
        que.add(new int[]{u, -1});
        visited[u] = true;
        
        while(!que.isEmpty()){
            int[] temp = que.poll();
            
            int source = temp[0];
            int parent = temp[1];
            
            for(int v : adj.get(source)){
                if(visited[v] == false){
                    visited[v] = true;
                    que.add(new int[]{v, source});
                }
                else if(v != parent){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
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
        
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i] && isCycleBFS(adj, i, visited)){
                return true;
            }
        }
        
        return false;
    }
}