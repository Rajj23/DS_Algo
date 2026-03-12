// T.C: O(V + E)
// S.C: O(V)
class Solution {
    int[][] directions = {{-1, 0}, {1,0}, {0,-1}, {0, 1}};

    boolean isValid(int x, int y, int m, int n){
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        if(image[sr][sc] == color) return image;

        final int orig = image[sr][sc];

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{sr, sc});
        image[sr][sc] = color;

        while(!que.isEmpty()){
            int[] curr = que.poll();

            int x = curr[0];
            int y = curr[1];

            for(int[] dir : directions){
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if(isValid(x_, y_, m, n) && image[x_][y_] == orig){
                    image[x_][y_] = color;
                    que.add(new int[]{x_,y_});
                }
            }
        }

        return image;
    }
}