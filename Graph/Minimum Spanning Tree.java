// Approach: Prims Algo
// T.C: O(Elog(E))
// S.C: O(E)
class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[] inMST = new boolean[V];
        int sum = 0;
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }
        
        pq.add(new int[]{0,0});
        
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int wt = temp[0];
            int node = temp[1];
            
            if(inMST[node] == true){
                continue;
            }
            
            inMST[node] = true;
            sum += wt;
            for(int[] vec : adj.get(node)){
                int adjNode = vec[0];
                int wt2 = vec[1];
                
                if(inMST[adjNode] == false)
                    pq.add(new int[]{wt2, adjNode});
            }
                
        }
        
        return sum;
    }
}





// Approach: Kruskal Algo
// T.C: O(E log E)
// S.C: O(E + V)
class Solution {
    
    int[] parent;
    int[] rank;
    
    int find(int x){
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    void Union(int x, int y){
        int x_parent = parent[x];
        int y_parent = parent[y];
        
        if(x_parent == y_parent) return;
        
        
        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }
    
    int Kruskal(List<int[]> adj){
        int sum = 0;
        
        for(int[] temp : adj){
            int u = temp[0];
            int v = temp[1];
            int wt = temp[2];
            
            int parent_u = find(u);
            int parent_v = find(v);
            
            if(parent_u != parent_v){
                Union(u, v);
                sum += wt;
            }
        }
        
        return sum;
    }
    
    public int spanningTree(int V, int[][] edges) {
        // code here
        parent = new int[V];
        rank = new int[V];
        
        for(int i = 0; i < V; i++){
            parent[i] = i;
        }
        
        List<int[]> adj = new ArrayList<>();
        
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            adj.add(new int[]{u, v, w});
        }
        
        Collections.sort(adj, (a, b)-> Integer.compare(a[2], b[2]));
        
        return Kruskal(adj);
    }
}