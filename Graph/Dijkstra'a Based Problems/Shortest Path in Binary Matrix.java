// T.C: O(V + E)
// S.C: O(V)
class Solution {

    int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));

        int[][] weight = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(weight[i], Integer.MAX_VALUE);
        }

        int ans = 0;

        weight[0][0] = 1;
        pq.add(new int[]{1,0,0});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int wt = temp[0];
            int r = temp[1];
            int c = temp[2];

            for(int i = 0; i < 8; i++){
                int newR = r + dr[i];
                int newC = c + dc[i];

                if(newR >= 0 && newR < n && newC >= 0 && newC < n && grid[newR][newC] == 0){
                    if(wt + 1 < weight[newR][newC]){
                        weight[newR][newC] = wt+1;
                        pq.add(new int[]{wt+1, newR, newC});
                    }
                }
            }
        }
        int cost = weight[n-1][n-1];

        return cost == Integer.MAX_VALUE ? -1 : cost;
    }
}


// T.C: O(V + E)
// S.C: O(V)
class Solution {

    int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0){
            return -1;
        }

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0,0});
        grid[0][0] = 1;

        int level = 0;

        while(!que.isEmpty()){
            int N = que.size();

            while(N > 0){
                int[] temp = que.poll();

                int x = temp[0];
                int y = temp[1];

                if(x == n-1 && y == n-1){
                    return level+1;
                }

                for(int i = 0; i < 8; i++){
                    int x_ = x + dr[i];
                    int y_ = y + dc[i];

                    if(x_ >= 0 && y_ >= 0 && x_ < n && y_ < n && grid[x_][y_] == 0){
                        que.add(new int[]{x_, y_});
                        grid[x_][y_] = 1;
                    }
                }
                N--;
            }
            level++;
        }

        return -1;
    }
}