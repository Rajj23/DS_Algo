class Solution {
    // Function to detect cycle using DSU in an undirected graph.
    int[] parent;
    int[] rank;
    
    int find(int x){
        if(x == parent[x]) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    void Union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);
        
        if(x_parent == y_parent){
            return;
        }
        
        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
        
    }
    
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        parent = new int[V];
        rank = new int[V];
        
        for(int i = 0; i < V; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int u = 0; u < V; u++){
            for(int v : adj.get(u)){
                
                if(u < v){
                    int parent_u = find(u);
                    int parent_v = find(v);
                    
                    if(parent_u == parent_v){
                        return 1;
                    }
                    
                    Union(u, v);
                }
            }
        }
        return 0;
    }
}