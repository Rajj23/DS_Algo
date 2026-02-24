//Approach-1 (Using Priority_queue and Adjacency list representation of graph) - Prim's Algorithm
class Solution {
    int PrismAlgo(List<List<int[]>> adj, int V){
        boolean[] inMST = new boolean[V];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));
        int sum = 0;

        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int wt = temp[0];
            int node = temp[1];

            if(inMST[node] == true) continue;

            inMST[node] = true;
            sum += wt;

            for(int[] vec : adj.get(node)){
                int adjNode = vec[0];
                int wt2 = vec[1];

                if(inMST[adjNode] == false){
                    pq.add(new int[]{wt2, adjNode});
                }
            }
        }
        return sum;
    }

    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>();
        int n = points.length;

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            int[] point1 = points[i];
            for(int j = i+1; j < n; j++){
                int[] point2 = points[j];

                int dist = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);

                adj.get(i).add(new int[]{j, dist});
                adj.get(j).add(new int[]{i, dist});
            }
        }

        return PrismAlgo(adj, n);
    }
}