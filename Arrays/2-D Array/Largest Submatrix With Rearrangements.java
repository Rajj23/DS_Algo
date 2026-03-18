// T.C: O(m*n*log(n))
// S.C: O(m*n)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxArea = 0;

        for(int row = 0; row < m ; row++){
            for(int col = 0; col < n; col++){

                if(matrix[row][col] == 1 && row > 0){
                    matrix[row][col] += matrix[row-1][col];
                }
            }
            int[] heights = matrix[row].clone();
            Arrays.sort(heights);

            for(int s = 0; s < n; s++){
                int base = (n - s);
                int height = heights[s];

                maxArea = Math.max(maxArea, base * height);
            }
        }
        return maxArea;
    }
}

//Approach-2 (Without modifying the given input)
//T.C : (m * nlogn)
//S.C : O(m*n)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] prevRow = new int[n];

        int maxArea = 0;

        for(int row = 0; row < m ; row++){
            int[] currRow = matrix[row];

            for(int col = 0; col < n; col++){

                if(matrix[row][col] == 1){
                    currRow[col] += prevRow[col];
                }
            }
            int[] heights = currRow;
            Arrays.sort(heights);

            for(int s = 0; s < n; s++){
                int base = (n - s);
                int height = heights[s];

                maxArea = Math.max(maxArea, base * height);
            }
            prevRow = currRow;
        }
        return maxArea;
    }
}

//Approach-3 (Without sorting)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    class Pair{
        int height;
        int col;

        public Pair(int height, int col){
            this.height = height;
            this.col = col;
        }
    }
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        List<Pair> prevHeights = new ArrayList<>();

        for(int row = 0; row < m; row++){
            
            List<Pair> currHeights = new ArrayList<>();
            boolean[] seen = new boolean[n];

            for(Pair  prev : prevHeights){
                int height = prev.height;
                int col = prev.col;

                if(matrix[row][col] == 1){
                    currHeights.add(new Pair(height+1, col));
                    seen[col] = true;
                }
            }

            for(int col = 0; col < n; col++){
                if(!seen[col] && matrix[row][col] == 1){
                    currHeights.add(new Pair(1, col));
                }
            }

            for(int i = 0; i < currHeights.size(); i++){
                int H = currHeights.get(i).height;
                int B = i+1;

                maxArea = Math.max(maxArea, B*H);
            }
            prevHeights = currHeights;
        }
        return maxArea;
    }
}