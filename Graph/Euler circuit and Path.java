// T.C: O(V + E)
// S.C: O(V)
class Solution {
    void DFS(ArrayList<ArrayList<Integer>> adj, int src,boolean[] visited){
        visited[src] = true;
        
        for(int adjNode : adj.get(src)){
            if(!visited[adjNode]){
                DFS(adj, adjNode, visited);
            }
        }
    }
    
    boolean isConnected(int V, ArrayList<ArrayList<Integer>> adj){
        
        int nonZeroDegreeVertex = -1;
        
        for(int i = 0; i < V; i++){
            if(adj.get(i).size() != 0){
                nonZeroDegreeVertex = i;
                break;
            }
        }
        
        if(nonZeroDegreeVertex == -1){
        return true;
    }
        boolean[] visited = new boolean[V];
        
        DFS(adj, nonZeroDegreeVertex, visited);
        
        for(int i = 0; i < V; i++){
            if(visited[i] == false && adj.get(i).size() > 0){
                return false;
            }
        }
        return true;
    }
    
    public int isEulerCircuit(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        if(isConnected(V, adj) == false){
            return 0;
        }
        
        
        int oddDegreeCound = 0;
        for(int i = 0; i < V; i++){
            if(adj.get(i).size() % 2 != 0){
                oddDegreeCound++;
            }
        }
        
        
        if(oddDegreeCound > 2){
            return 0;
        }
        
        if(oddDegreeCound == 0){
            return 2;
        }
        
        return 1;
    }
}