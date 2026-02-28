// Time  : O(V+E), V = # vertices, E = # edges , Space : O(V)
class Solution {
    void dfsFill(int src, List<List<Integer>> adj, boolean[] visited, Stack<Integer> st){
        if(visited[src]) return;
        
        visited[src] = true;
        
        for(int adjNode : adj.get(src)){
            if(!visited[adjNode]){
                
                dfsFill(adjNode, adj, visited, st);
                
            }
        }
        st.add(src);
    }
    
    
    void dfsTraversal(int src, List<List<Integer>> adj, boolean[] visited){
        visited[src] = true;
        
        for(int adjNode : adj.get(src)){
            if(!visited[adjNode]){
                
                dfsTraversal(adjNode, adj, visited);
            }
        }
    }
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
        // code here
        
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
        }
        
        
        for(int i = 0; i < V; i++){
            
            if(!visited[i]){
                dfsFill(i, adj, visited, st);
            }
            
        }
        
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            revAdj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            revAdj.get(v).add(u);
        }
        
        int countScc = 0;
        Arrays.fill(visited, false);
        
        while(!st.isEmpty()){
            
            int node = st.pop();
            
            if(!visited[node]){
                dfsTraversal(node, revAdj, visited);
                countScc++;
            }
        }
        
        return countScc;
    }
}