// T.C: O(V + E)
// S.C: O(V + E)
class Solution {
    List<Integer> BFS(List<List<Integer>> adj, int src){
        Queue<Integer> que = new ArrayDeque<>();
        int n = adj.size();

        boolean[] visited = new boolean[n];
        int distance = 0;
        int farthestNode = src;

        visited[src] = true;
        que.add(src);

        while(!que.isEmpty()){
            int size = que.size();

            for(int i = 0; i < size; i++){
                int curr = que.poll();

                farthestNode = curr;

                for(int adjNode : adj.get(curr)){
                    if(!visited[adjNode]){
                        que.add(adjNode);
                        visited[adjNode] = true; 
                    }

                }
            }
            if(!que.isEmpty())
                distance++;
        }

        return Arrays.asList(farthestNode, distance);
    }
    
    int findDiameter(List<List<Integer>> adj){

        List<Integer> farthestNode = BFS(adj, 0);

        farthestNode = BFS(adj, farthestNode.get(0));

        return farthestNode.get(1);
    }
    
    List<List<Integer>> buildAdj(int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<List<Integer>> adj1 = buildAdj(edges1);
        List<List<Integer>> adj2 = buildAdj(edges2);

        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);

        int combined = (d1 + 1)/2 + (d2 + 1)/2 + 1;

        return Math.max(d1, Math.max(d2, combined));
    }
}