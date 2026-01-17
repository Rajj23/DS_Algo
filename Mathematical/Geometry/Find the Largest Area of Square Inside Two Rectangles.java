//T.C : O(n * n)
//S.C : O(1)
class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;

        int maxSize = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                
                int topRightX = Math.min(topRight[i][0], topRight[j][0]);
                int bottomLeftX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);

                int width = topRightX - bottomLeftX;

                int topRightY = Math.min(topRight[i][1], topRight[j][1]);
                int bottomLeftY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                int height = topRightY - bottomLeftY;

                int side = Math.min(width, height);

                maxSize = Math.max(maxSize, side);
            }
        }

        return (long) maxSize * maxSize;
    }
}