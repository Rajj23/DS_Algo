// T.C: O(V+E)
// S.C: O(V)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] e : prerequisites){
            int u = e[1];
            int v = e[0];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> que = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }

        int count = 0;

        while(!que.isEmpty()){
            int u = que.poll();
            count++;
            
            for(int v : adj.get(u)){
                indegree[v]--;

                if(indegree[v] == 0){
                    que.add(v);
                }
            }
        }

        return count == numCourses;
    }
}


// T.C: O(V+E)
// S.C: O(V)
class Solution {
    boolean DFS(int u, List<List<Integer>> adj, boolean[] pathVis, boolean[] visited){
       
        visited[u] = true;
        pathVis[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                if (DFS(v, adj, visited, pathVis))
                    return true;
            } 
            else if (pathVis[v]) {
                return true; // cycle detected
            }
        }

        pathVis[u] = false; // backtrack
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : prerequisites){
            int u = e[1];
            int v = e[0];

            adj.get(u).add(v);
        }

        boolean[] pathVis = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(DFS(i, adj, pathVis, visited)) return false;
            }
        }

        return true;
    }
}