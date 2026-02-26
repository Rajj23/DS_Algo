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




//Approach-2 (Using 2-D matrix graph) - Prim's Algorithm
class Solution {
    int[] parent;
    int[] rank;

    int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void Union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent) return;

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

    int Kruskal(List<int[]> vec){
        int sum = 0;

        for(int[] curr : vec){
            int u = curr[0];
            int v = curr[1];
            int wt = curr[2];

            int parent_u = find(u);
            int parent_v = find(v);

            if(parent_u != parent_v){
                Union(u, v);
                sum += wt;
            }
        }

        return sum;
    }

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;

        parent = new int[V];
        rank = new int[V];

        for(int i = 0; i < V; i++){
            parent[i] = i;
        }

        List<int[]> vec = new ArrayList<>();

        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                
                int x1 = points[i][0];
                int x2 = points[j][0];

                int y1 = points[i][1];
                int y2 = points[j][1];

                int d = Math.abs(x1-x2) + Math.abs(y1-y2);

                vec.add(new int[]{i, j, d});
            }
        }

        Collections.sort(vec, (a, b)-> Integer.compare(a[2], b[2]));

        return Kruskal(vec);
    }
}
