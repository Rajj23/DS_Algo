// T.C: O(n^3)
// S.C: O(1)
class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int INF = (int) 1e8;
        int n = dist.length;
        for(int via = 0; via < n; via++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][via] != INF && dist[via][j] != INF)
                        dist[i][j] = Math.min(dist[i][j], 
                        dist[i][via] + dist[via][j]);
                }
            }
        }
    }
}