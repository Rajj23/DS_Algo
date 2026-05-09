// Approach: Top down (little bit slow)
// T.C: O(n*n)
// S.C: O(n*n*n)
class Solution {
    int n;

    Map<String, Integer> t;
    int solve(int i, int j, int steps, int[][] fruits){
        if(i < 0 || i >= n || j < 0 || j >= n) return Integer.MIN_VALUE;

        if(i <= j) return Integer.MIN_VALUE;

        if(i == n-1 && j == n-2){
            if(steps == n-2){
                return fruits[i][j];
            }
            else{
                return Integer.MIN_VALUE;
            }
        }

        String key = i + "_" + j + "_" + steps;
        if(t.containsKey(key)) return t.get(key);
        
        steps += 1;
        int digT = solve(i-1, j+1, steps, fruits);
        int right = solve(i, j+1, steps, fruits);
        int digB = solve(i+1, j+1, steps, fruits);

        int best = Math.max(digT, Math.max(right, digB));

        if(best == Integer.MIN_VALUE){
            t.put(key, Integer.MIN_VALUE);
            return Integer.MIN_VALUE;
        }

        t.put(key, fruits[i][j] + best);
        return fruits[i][j] + best;
    }

    int solve2(int i, int j, int steps, int[][] fruits){
        if(i < 0 || i >= n || j < 0 || j >= n) return Integer.MIN_VALUE;

        if(i >= j) return Integer.MIN_VALUE;

        if(i == n-2 && j == n-1){
            if(steps == n-2){
                return fruits[i][j];
            }
            else return Integer.MIN_VALUE;
        }

        String key = i + "_" + j + "_" + steps;
        if(t.containsKey(key)) return t.get(key);

        steps += 1;
        int digP = solve2(i+1, j-1, steps, fruits);
        int down = solve2(i+1, j, steps, fruits);
        int digB = solve2(i+1, j+1, steps, fruits);

        int best = Math.max(digP, Math.max(down, digB));

        if(best == Integer.MIN_VALUE){
            t.put(key, Integer.MIN_VALUE);
            return Integer.MIN_VALUE;
        }

        t.put(key, fruits[i][j] + best);
        return fruits[i][j] + best;
    }

    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;

        int c1 = 0;
        for(int i = 0; i < n; i++){
            c1 += fruits[i][i];
        }

        t = new HashMap<>();

        int c2 = solve(n-1, 0, 0, fruits);
        int c3 = solve2(0, n-1, 0, fruits);

        return c1+c2+c3;
    }
}


// Approach: Top down
// T.C: O(n*n)
// S.C: O(n*n)
class Solution {
    int n;

    int[][] t;

    int solve2(int i, int j, int[][] fruits){
        if(i < 0 || i >= n || j < 0 || j >= n) return 0;

        if(i == n-1 && j == n-1){
            return 0;
        }

        if(i == j || i > j){
            return 0;
        }

        if(t[i][j] != -1) return t[i][j];

        int digP = solve2(i+1, j-1, fruits);
        int down = solve2(i+1, j, fruits);
        int digB = solve2(i+1, j+1, fruits);

        int best = Math.max(digP, Math.max(down, digB));

        return t[i][j] = fruits[i][j] + best;
    }


    int solve3(int i, int j, int[][] fruits){
        if(i < 0 || i >= n || j < 0 || j >= n) return 0;

        if(i == n-1 && j == n-1) return 0;

        if(i == j || i < j) return 0;

        if(t[i][j] != -1) return t[i][j];

        int digT = solve3(i-1, j+1, fruits);
        int right = solve3(i, j+1, fruits);
        int digB = solve3(i+1, j+1, fruits);

        int best = Math.max(digT, Math.max(right, digB));

        return t[i][j] = fruits[i][j] + best;
    }


    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        t = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(t[i], -1);
        }

        int c1 = 0;
        for(int i = 0; i < n; i++){
            c1 += fruits[i][i];
        }


        int c2 = solve2(0, n-1,fruits);
        int c3 = solve3(n-1, 0, fruits);

        return c1+c2+c3;
    }
}

// Approach: Bottom up
// T.C: O(n*n) 
// S.C: O(n*n)
class Solution {
    public int maxCollectedFruits(int[][] fruits){
        int n = fruits.length;

        int[][] t = new int[n][n];

        int result = 0;
        for(int i = 0; i < n; i++){
            result += fruits[i][i];
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i < j && i+j < n-1){
                    t[i][j] = 0;
                }
                else if(i > j && i+j < n-1){
                    t[i][j] = 0;
                }
                else{
                    t[i][j] = fruits[i][j];
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = i+1; j < n; j++){
                t[i][j] += Math.max(t[i-1][j-1], Math.max(t[i-1][j], (j+1 < n) ? t[i-1][j+1] : 0));
            }
        }

        for(int j = 1; j < n; j++){
            for(int i = j+1; i < n; i++){
                t[i][j] += Math.max(t[i-1][j-1], Math.max(t[i][j-1], (i+1 < n) ? t[i+1][j-1] : 0));
            }
        }

        return result + t[n-2][n-1] + t[n-1][n-2];
    }
}