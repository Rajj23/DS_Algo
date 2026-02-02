// T.C: O(V + E)
// S.C: O(V)
class Solution {
    void DFS(List<List<Integer>> adj, int u, boolean[] visited){
        visited[u] = true;

        for(int e : adj.get(u)){
            if(!visited[e]){
                DFS(adj, e, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int u = 0; u < V; u++){
            for(int v = 0; v < V; v++){
                if(u == v) continue;

                if(isConnected[u][v] == 1){
                    adj.get(u).add(v);
                }
            }
        }

        boolean[] visited = new boolean[V];
        int provision = 0;
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                provision++;
                DFS(adj, i, visited);
            }
        }

        return provision;
    }
}

// T.C: O(V + E)
// S.C: O(V)
class Solution {
    int V;
    void DFS(int[][] isConnected, int u, boolean[] visited){
        visited[u] = true;

        for(int v = 0; v < V; v++){
            if(!visited[v] && isConnected[u][v] == 1){
                DFS(isConnected, v, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        V = isConnected.length;


        boolean[] visited = new boolean[V];
        int provision = 0;
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                provision++;
                DFS(isConnected, i, visited);
            }
        }

        return provision;
    }
}



// T.C: O(V + E)
// S.C: O(V)
class Solution {
    int N;

    void BFS(int[][] isConnected, int e, boolean[] visited){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(e);
        while(!que.isEmpty()){
            int u = que.poll();
            for(int v = 0; v < N; v++){
                if(!visited[v] && isConnected[u][v] == 1){
                    visited[v] = true;
                    que.add(v);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        N = isConnected.length;

        int provision = 0;
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                BFS(isConnected, i, visited);
                provision++;
            }
        }

        return provision;
    }
}