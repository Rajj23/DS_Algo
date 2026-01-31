// T.C: O(n*log(n))
// S.C: (1)
class Solution {
    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, (a, b) -> {
        //     if (a[1] != b[1])
        //         return a[1] - b[1];
        //     return a[0] - b[0];
        // });

        Arrays.sort(points, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int count = 1;
        int prev = points[0][1];
        int n = points.length;

        for (int i = 1; i < n; i++) {
            if (prev < points[i][0]) {
                prev = points[i][1];
                count++;
            }
        }

        return count;
    }
}