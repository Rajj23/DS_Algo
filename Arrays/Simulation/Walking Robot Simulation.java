//Simple Simulation
//T.C : O(m + n * maxValCommand), m = size of obstacles, n = size of commands
//S.C : O(m)
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obst : obstacles) {
            set.add(obst[0] + "_" + obst[1]);
        }

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        int dir = 0;

        int dirX = 0;
        int dirY = 0;

        int ans = 0;

        for (int com : commands) {
            if (com >= 0) {
                boolean isFoundObstacle = false;

                for (int i = 1; i <= com; i++) {
                    int tempX = dirX + i * dx[dir];
                    int tempY = dirY + i * dy[dir];

                    if (set.contains(tempX + "_" + tempY)) {
                        dirX = dirX + (i - 1) * dx[dir];
                        dirY = dirY + (i - 1) * dy[dir];
                        isFoundObstacle = true;
                        break;
                    }
                }
                if (!isFoundObstacle) {
                    dirX = dx[dir] != 0 ? dirX + com * dx[dir] : dirX;
                    dirY = dy[dir] != 0 ? dirY + com * dy[dir] : dirY;
                }

                ans = Math.max(ans, (dirX * dirX + dirY * dirY));

            } else {
                if (com == -1) {
                    dir = (dir + 1) % 4;
                } else {
                    dir = (dir + 3) % 4;
                }
            }
        }
        return ans;
    }
}