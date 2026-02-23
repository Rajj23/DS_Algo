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
