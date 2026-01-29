//Approach-1 (Using Simple Dijkstra's Algorithm)
//T.C : n * (time complexity of Dijkstra) = O(n * (V+E)logV) , where V = number of vertices and E = number of edges
//S.C : O(V+E) -> We create a graph, where V = number of vertices and E = number of edges
class Solution {
    void dijkstra(int source, List<List<int[]>> adj, long[][] costMatrix){
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Long.compare(a[0], b[0])
        );

        costMatrix[source][source] = 0;
        pq.add(new int[]{0,source});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int d = temp[0];
            int node = (int)temp[1];

            if (d > costMatrix[source][node]) continue;

            for(int[] e : adj.get(node)){
                int adjNode = e[0];
                int dis = e[1];

                if(d+dis < costMatrix[source][adjNode]){
                    costMatrix[source][adjNode] = d+dis;
                    pq.add(new int[]{d+dis, adjNode});
                }
            }
        }
        return;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = original.length;
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < 26; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int w = cost[i];

            adj.get(u).add(new int[]{v,w});
        }

        long INF = (long) 1e18;
        long[][] costMatrix = new long[26][26];
        for(int i = 0; i < 26; i++){
            Arrays.fill(costMatrix[i], INF);
        }

        for (int i = 0; i < 26; i++) {
            dijkstra(i, adj, costMatrix);
        }


        long totalCost = 0;

        for(int i = 0; i < source.length(); i++){
            int src = source.charAt(i) - 'a';
            int tar = target.charAt(i) - 'a';

            if(src == tar){
                continue;
            }

            if(costMatrix[src][tar] == INF){
                return -1;
            }

            totalCost += costMatrix[src][tar];
        }

        return totalCost;
    }
}
