// T.C: O(V) + O(E)
// S.C: O(V)
class Solution {
    void DFS(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, ArrayList<Integer> result){
        if(visited[u] == true){
            return;
        }
        
        visited[u] = true;
        result.add(u);
        
        for(int v : adj.get(u)){
            if(!visited[v]){
                DFS(adj, v, visited, result);
            }
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        DFS(adj, 0, visited, result);
        
        return result;
    }
}