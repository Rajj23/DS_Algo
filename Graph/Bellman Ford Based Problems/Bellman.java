// T.C: O(V*E)
// S.C: O(V)
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] result = new int[V];
        Arrays.fill(result, (int) 1e8);
        result[src] = 0;
        
        for(int count = 1; count <= V-1; count++){
            
            for(int[] edge : edges){
                
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                
                if(result[u] != (int) 1e8 && result[u] + wt < result[v]){
                    result[v] = result[u] + wt;
                }
            }
        }
        
        for(int[] edge : edges){
                
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            if(result[u] != (int) 1e8 && 
                result[u] + wt < result[v]){
                    
                    return new int[]{-1};
                }
        }
        
        return result;
    }
}
