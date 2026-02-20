// T.C: O(V + E)
// S.C: O(V)
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] result = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));

        pq.add(new int[]{0, 0, 0});
        result[0][0] = 0;

        while(!pq.isEmpty()){
            int[] temp = pq.poll();

            int diff = temp[0];
            int x = temp[1];
            int y = temp[2];

            for(int i = 0; i < 4; i++){
                int x_ = x + dx[i];
                int y_ = y + dy[i];
                
                if(x_ >= 0 && y_ >= 0 && x_ < n && y_ < m){
                    int cost = Math.max(diff, Math.abs(heights[x][y] - heights[x_][y_]));

                    if(result[x_][y_] > cost){
                        result[x_][y_] = cost;
                        pq.add(new int[]{cost, x_, y_});
                    }
                }

            }
        }

        return result[n-1][m-1];
    }
}