// T.C: O(n*m)
// S.C: O(n*m)
class Solution {
    int m;
    int n;

    int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    boolean isValid(int r, int c){
        return r >= 0 && c >= 0 && r < m && c < n;
    }

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int time = 0;
        int fresh = 0;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1)
                    fresh++;
            }
        }


        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int i = 0; i < size; i++){

                int[] temp = q.poll();

                int x = temp[0];
                int y = temp[1];

                for(int[] dir : direction){
                    int x_ = x + dir[0];
                    int y_ = y + dir[1];

                    if(isValid(x_, y_) && grid[x_][y_] == 1){
                        grid[x_][y_] = 2;
                        q.add(new int[]{x_, y_});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }   
}