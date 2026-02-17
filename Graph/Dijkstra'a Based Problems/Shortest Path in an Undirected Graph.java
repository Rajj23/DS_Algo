// T.C: O(V + E)
// S.C: O(2n)
class Solution {

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        
        int[] parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        
        result[1] = 0;
        pq.add(new int[]{0,1});
        
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            
            int d = temp[0];
            int node = temp[1];
            
            for(int[] vec : adj.get(node)){
                int adjNode = vec[0];
                int wt = vec[1];
                
                if(d+wt < result[adjNode]){
                    result[adjNode] = d+wt;
                    pq.add(new int[]{d+wt, adjNode});
                    parent[adjNode] = node;
                }
            }
        }
        
        int destNode = n;
        if(result[destNode] == Integer.MAX_VALUE){
            return Arrays.asList(-1);
        }
        
        List<Integer> path = new ArrayList<>();
        
        
        while(parent[destNode] != destNode){
            path.add(destNode);
            destNode = parent[destNode];
        }
        
        path.add(1);
        
        Collections.reverse(path);
        path.add(0, result[n]);
        return path;

    }
}