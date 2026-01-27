// Approach: Build an adjacency list and run Dijkstra's algorithm from src using a min-heap (PriorityQueue) that always expands the node with the current smallest distance.
// T.C: O((V + E) * log V)
// S.C: O(V + E)
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0], b[0]));
            
            int[] result = new int[V];
            Arrays.fill(result, Integer.MAX_VALUE);
            
            result[src] = 0;
            pq.add(new int[]{0, src});
            
            while(!pq.isEmpty()){
                
                int[] temp = pq.poll();
                int d = temp[0];
                int node = temp[1];
                
                for(int[] vec : adj.get(node)){
                    int adjNode = vec[0];
                    int wt = vec[1];
                    
                    if(d + wt < result[adjNode]){
                        result[adjNode] = d + wt;
                        pq.add(new int[]{d+wt, adjNode});
                    }
                }
            }
            
            return result;
    }
}


// Approach: Build an adjacency list and run Dijkstra's algorithm from src using a TreeSet ordered by (distance, node) to simulate a decrease-key operation by removing and re-inserting updated distances.
// T.C: O((V + E) * log V)
// S.C: O(V + E)
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        
        TreeSet<int[]> st = new TreeSet<>(
            (a,b) -> {
                if(a[0] != b[0]) return a[0] - b[0];
                
                return a[1] - b[1]; 
            });
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        
        st.add(new int[]{0, src});
        result[src] = 0;
        
        while(!st.isEmpty()){
            int[] temp = st.pollFirst();
            int d = temp[0];
            int node = temp[1];
            
            for(int[] vec : adj.get(node)){
                int adjNode = vec[0];
                int wt = vec[1];
                
                if(d + wt < result[adjNode]){
                    int tempDist = result[adjNode]; 
                    int[] rem = new int[]{tempDist, adjNode};
                    st.remove(rem);
                    result[adjNode] = d + wt;
                    st.add(new int[]{d+wt, adjNode});
                }
            }
        }
        
        return result;
    }
}