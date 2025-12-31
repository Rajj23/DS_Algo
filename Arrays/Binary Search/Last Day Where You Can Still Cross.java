//Approach-1 (Using Binary Search + DFS)
// T.C: O(row*col * log col)
// S.C: O(1)
class Solution {
    int ROW;
    int COL;

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    boolean DFS(int[][] grid, int i,int j){
        if(i<0 || i>=ROW || j<0 || j>= COL || grid[i][j]==1){
            return false;
        }

        if(i==ROW - 1)
            return true;

        grid[i][j] = 1;

        for(int[] dir:directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if(DFS(grid,new_i, new_j)){
                return true; 
            }
        }
        return false;
    }

    boolean canCross(int[][] cells, int mid){
        int[][] grid = new int[ROW][COL];

        for(int i=0;i<=mid;i++){
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;

            grid[x][y] = 1;
        }

        for(int j=0;j<COL;j++){
            if(grid[0][j] == 0 && DFS(grid,0,j)){
                return true;
            }
        }        

        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW = row;
        COL = col;

        int l = 0;
        int r = cells.length-1;

        int lastDay = 0;

        while(l<=r){
            int mid = l+ (r-l)/2;

            if(canCross(cells,mid)){
                lastDay = mid+1;
                l = mid+1;
            }
            else{
                r = mid - 1;
            }
        }

        return lastDay;
    }
}

//Approach-2 (Using Binary Search + BFS)
// T.C: O(row*col * log col)
// S.C: O(row*col)
class Solution {
    int ROW;
    int COL;

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    boolean BFS(int[][] grid, int i,int j){
        Queue<int[]> que = new LinkedList<>(); 
        que.add(new int[]{i,j});
        grid[i][j] = 1;

        while(!que.isEmpty()){
            int[] cell = que.poll();
            int x = cell[0];
            int y = cell[1];

            if(x == ROW-1){
                return true;
            }

            for(int[] dir:directions){
                int new_x = x + dir[0];
                int new_y = y + dir[1];

                if(new_x >=0 && new_x < ROW && 
                    new_y >= 0 && new_y < COL &&
                    grid[new_x][new_y] == 0){
                        que.add(new int[]{new_x,new_y});
                        grid[new_x][new_y]=1;
                    }
            }
        }
        return false;
    }

    boolean canCross(int[][] cells, int mid){
        int[][] grid = new int[ROW][COL];

        for(int i=0;i<=mid;i++){
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;

            grid[x][y] = 1;
        }

        for(int j=0;j<COL;j++){
            if(grid[0][j] == 0 && BFS(grid,0,j)){
                return true;
            }
        }        

        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW = row;
        COL = col;

        int l = 0;
        int r = cells.length-1;

        int lastDay = 0;

        while(l<=r){
            int mid = l+ (r-l)/2;

            if(canCross(cells,mid)){
                lastDay = mid+1;
                l = mid+1;
            }
            else{
                r = mid - 1;
            }
        }

        return lastDay;
    }
}