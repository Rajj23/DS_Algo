//Approach (Recursion + Memoization + Binary Search)
//T.C : O(n * log(w) + nlogn + wlogw), n = robots.size(), w = walls.size()
//S.C : O(n)
class Solution {
    int[][] t;

    int lowerBound(int[] arr, int tar){
        int n = arr.length;
        int l = 0;
        int r = n-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(arr[mid] < tar){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return l;
    }

    int upperBound(int[] arr, int tar){
        int n = arr.length;
        int l = 0;
        int r = n-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(arr[mid] <= tar){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return l;
    }

    int countWalls(int[] walls, int l, int r){
        int left = lowerBound(walls, l);
        int right = upperBound(walls, r);

        return right - left;
    }

    int solve(int[] walls, int[][] roboDist, int[][] range, int i, int prevDir){

        if(i == roboDist.length) return 0;

        if(t[i][prevDir] != -1) return t[i][prevDir];

        int leftStart = range[i][0];

        if(prevDir == 1 && i > 0){
            leftStart = Math.max(leftStart, range[i-1][1]+1);
        }

        int leftTake = countWalls(walls, leftStart, roboDist[i][0]) +
                        solve(walls, roboDist, range, i+1, 0);

        int rightTake = countWalls(walls, roboDist[i][0], range[i][1]) +
                        solve(walls, roboDist, range, i+1, 1);

        
        return t[i][prevDir] = Math.max(leftTake, rightTake);
    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        t = new int[n+1][2];
        for(int i = 0;i < n; i++){
            Arrays.fill(t[i], -1);
        }

        int[][] roboDist = new int[n][2];
        for(int i = 0; i < n; i++){
            roboDist[i][0] = robots[i];
            roboDist[i][1] = distance[i];
        }
        Arrays.sort(roboDist, (a, b)-> Integer.compare(a[0], b[0]));
        Arrays.sort(walls);

        int[][] range = new int[n][2];
        for(int i = 0; i < n; i++){
            int pos = roboDist[i][0];
            int d = roboDist[i][1];

            int leftLimit = (i == 0 ) ? 1 : roboDist[i-1][0]+1;
            int rightLimit = (i == n-1) ? (int)1e9 : roboDist[i+1][0]-1;

            int L = Math.max(pos - d, leftLimit);
            int R = Math.min(pos + d, rightLimit);

            range[i][0] = L;
            range[i][1] = R;
        }

        return solve(walls, roboDist, range, 0, 0);
    }
}   