// T.C: O(n*n * logn)
// S.C: O(n*n)
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    boolean isPossible(int[][] dist, int limit){
        int n = dist.length;

        if(dist[0][0] < limit) return false;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0] == n-1 && curr[1] == n-1) return true;

            for(int[] d : dirs){
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

                if(visited[nr][nc]) continue;

                if(dist[nr][nc] < limit) continue;

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return false;
    }   

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int[][] minDist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(minDist[i], -1);
        }

        Queue<int[]> pq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    pq.add(new int[]{i, j});
                    minDist[i][j] = 0;
                }
            }
        }

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int row = curr[0];
            int col = curr[1];

            for(int[] dir : dirs){
                int row_ = row + dir[0];
                int col_ = col + dir[1];

                if(row_ < 0 || col_ < 0 || row_ >= n || col_ >= n) continue;

                if(minDist[row_][col_] == -1){
                    minDist[row_][col_] = minDist[row][col] + 1;
                    pq.add(new int[]{row_, col_});
                }
            }
        }

        int l = 0, r = 401;
        int ans = 0;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(isPossible(minDist, mid)){
                ans = mid;
                l = mid+1;
            }
            else{
                r = mid - 1;
            }
        }

        return ans;
    }
}