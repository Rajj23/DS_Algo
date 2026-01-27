// Approach: Build a modified adjacency list where each directed edge u->v with cost w is stored as (u -> v, w) and the reverse direction (v -> u, 2*w), then run Dijkstra's algorithm from node 0 using a min-heap to find the minimum-cost path to node n-1.
// T.C: O((n + m) * log n), where m is the number of edges
// S.C: O(n + m)
class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, 2 * w});
        }

        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0], b[0])
        );

        pq.add(new int[]{0, 0});
        result[0] = 0;

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int d = temp[0];
            int node = temp[1];

            if(node == n-1){
                return result[n-1];
            }
            
            for(int[] vec : adj.get(node)){
                int adjNode = vec[0];
                int wt = vec[1];
                if(d + wt < result[adjNode]){
                    result[adjNode] = d + wt;
                    pq.add(new int[]{d+wt, adjNode});
                }
            }
        }

        return -1;
    }
}