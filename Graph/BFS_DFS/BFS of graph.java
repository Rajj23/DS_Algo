// T.C: O(V) + O(E)
// S.C: O(V)
class Solution {
    void BFS(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, ArrayList<Integer> result){
        Queue<Integer> que = new LinkedList<>();
        
        que.add(u);
        visited[u] = true;
        result.add(u);
        
        while(!que.isEmpty()){
            u = que.poll();
            
            for(int v : adj.get(u)){
                if(!visited[v]){
                    que.add(v);
                    visited[v] = true;
                    result.add(v);
                }
            }
        }
    }
    
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v = adj.size();
        boolean[] visited = new boolean[v];
        ArrayList<Integer> result = new ArrayList<>();
        
        BFS(adj, 0, visited, result);
        return result;
    }
}