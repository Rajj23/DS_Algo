//Approach-1 (Binary Search + Backtracking Brute Force)
//T.C : O(nCk * k * log side)
//S.C : O(k)
class Solution {

    int manhattanDist(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    boolean check(int[][] points, int k, int mid, int i, List<Integer> chosen){
        if(chosen.size() == k){
            return true;
        }

        for(int p = i; p < points.length; p++){
            boolean valid = true;

            for(int idx : chosen){
                if(manhattanDist(points[p], points[idx]) < mid){
                    valid = false;
                    break;               
                }
            }

            if(!valid) continue;

            chosen.add(p);
            if(check(points, k, mid, p+1, chosen)){
                return true;
            }
            chosen.remove(chosen.size()-1);
        }
        return false;
    }

    public int maxDistance(int side, int[][] points, int k) {
        int l = 0;
        int r = 2*side;

        int result = 0;

        while(l <= r){
            int mid = l + (r-l)/2;

            List<Integer> chosen = new ArrayList<>();

            if(check(points, k, mid, 0, chosen)){
                result = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return result;
    }
}

//Approach-2 (Binary Search + Optimised check)
//T.C : O(nlogn+log(side)⋅n⋅klogn)
//S.C : O(n)
class Solution {
    long get1D(int side, int x, int y){
        if(y == 0) return x;

        if(x == side) return (long) side+y;
        if(y == side) return 3L * side - x;

        return 4L * side - y;
    }

    int lowerBound(long[] doubled, int l, int r, long tar){
        int ans = r;
        while(l < r){
            int mid = l + (r-l)/2;

            if(doubled[mid] >= tar){
                ans = mid;

                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }

    boolean check(long[] doubled, int n, int k, int side, int mid){
        long perimeter = 4l * side;
        for(int i = 0; i < n; i++){
            int count = 1;
            int idx = i;

            long lastPos = doubled[idx];

            for(int j = 2; j <= k; j++){
                long target = lastPos + mid;

                int it = lowerBound(doubled, idx+1, i+n, target);

                if(it == i+n) break;

                idx = it;
                lastPos = doubled[idx];
                count++;
            }
            if(count == k && (doubled[i] + perimeter-lastPos >= mid)){
                return true;
            }
            
        }
        return false;
    }

    public int maxDistance(int side, int[][] points, int k) {
        long perimeter = 4L * side;
        int n = points.length;

        long[] positions = new long[n];
        for(int i = 0; i < n; i++){
            positions[i] = get1D(side, points[i][0], points[i][1]);
        }

        Arrays.sort(positions);

        long[] doubled = new long[2*n];
        for(int i = 0; i < n; i++){
            doubled[i] = positions[i];
            doubled[i+n] = positions[i] + perimeter;
        }

        int l = 0;
        int r = 2*side;

        int result = 0;
        while(l <= r){
            int mid = l + (r-l)/2;

            if(check(doubled, n, k, side, mid)){
                result = mid;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return result;
    }
}