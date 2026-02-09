// T.C: O(V + E)
// S.C: O(V)
class Solution {
    boolean checkIsBipartiteDFS(int[][] graph, int curr, int[] color, int currColor){
        color[curr] = currColor;

        for(int e : graph[curr]){
            if(color[e] == color[curr]){
                return false;
            }

            if(color[e] == -1){
                int currColorOfE = 1 - currColor;
                if(checkIsBipartiteDFS(graph, e, color, currColorOfE) == false){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(checkIsBipartiteDFS(graph, i, color, 1) == false){
                    return false;
                }
            }
        }

        return true;
    }
}


// T.C: O(V + E)
// S.C: O(V)
class Solution {
    boolean checkBipartiteBFS(int[][] graph, int curr, int[] color, int currColor){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(curr);
        color[curr] = currColor;

        while(!que.isEmpty()){
            int u = que.poll();

            for(int v : graph[u]){
                if(color[v] == color[u]){
                    return false;
                }
                else if(color[v] == -1) {
                    color[v] = 1 - color[u];
                    que.add(v);
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                if(checkBipartiteBFS(graph, i, color, 1) == false){
                    return false;
                }
            }
        }

        return true;
    }
}