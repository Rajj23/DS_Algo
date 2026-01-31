// T.C: O(v+E)
// S.C: O(n)
class Solution {
    
    void dfs(int u, List<List<Integer>> adj, boolean[] visited, Stack<Integer> st){
        visited[u] = true;
        
        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(v, adj, visited, st);
            }
        }
        
        st.push(u);
    }
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i <  V; i++){
            if(!visited[i]){
                dfs(i, adj, visited, st);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        
        return result;
    }
}



// T.C: O(v+E)
// S.C: O(n)
class Solution{
    public ArrayList<Integer> topoSort(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            
            adj.get(u).add(v);
        }
        
        boolean[] visited = new boolean[V];
        int[] indegree = new int[V];
        Queue<Integer> que = new LinkedList<>();
        
        for(int u = 0; u < V; u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }
        
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }
        
       ArrayList<Integer> result = new ArrayList<>();
        while(!que.isEmpty()){
            int u = que.poll();
            result.add(u);
            
            for(int v : adj.get(u)){
                indegree[v]--;
                
                if(indegree[v] == 0){
                    que.add(v);
                }
            }
        }
        
        return result;
    }
}
 
 
 
 
 
 
 
 
 
 