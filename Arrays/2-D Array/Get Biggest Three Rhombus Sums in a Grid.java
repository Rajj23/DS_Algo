//Approach-1 (Brute Force)
//T.C : O(m*n * min(m, n)^2)
//S.C : O(1)
class Solution {
    void setAdd(TreeSet<Integer> set, int val){
        set.add(val);
        if(set.size() > 3){
            set.pollLast();
        }
    }

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                setAdd(set, grid[r][c]);
                
                for(int side = 1; r-side >= 0 && r+side < m && c-side >= 0 && c+side < n; side++){
                    int sum = 0;
                    for(int k = 0; k <=side-1; k++){
                        sum += grid[r-side+k][c+k];
                        sum += grid[r+k][c+side-k];

                        sum += grid[r+side-k][c-k];
                        sum += grid[r-k][c-side+k];
                    }

                    setAdd(set, sum);
                }
            }
        }

        int[] result = new int[Math.min(3, set.size())];

        int i = 0;
        while(!set.isEmpty() && i < 3){
            result[i] = set.pollFirst();
            i++;
        }

        return result;
    }
}


//Approach-2 (Using Diagonal Prefix Sum to get rid of innermost for loop)
//T.C : O(m*n * min(m, n))
//S.C : O(m*n)
class Solution {
    void setAdd(TreeSet<Integer> set, int val){
        set.add(val);
        if(set.size() > 3){
            set.pollLast();
        }
    }

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int[][] d1 = new int[m][n];
        int[][] d2 = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                d1[i][j] = grid[i][j];
                if(i-1 >= 0 && j - 1 >= 0){
                    d1[i][j] += d1[i-1][j-1];
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                d2[i][j] = grid[i][j];
                if(i-1 >= 0 && j + 1 < n){
                    d2[i][j] += d2[i-1][j+1];
                }
            }
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                setAdd(set, grid[r][c]);
                
                for(int side = 1; r-side >= 0 && r+side < m && c-side >= 0 && c+side < n; side++){
                    int sum = 0;
                    
                    int top_r = r - side, top_c = c;
                    int right_r = r, right_c = c + side;

                    int bottom_r = r+side, bottom_c = c;
                    int left_r = r, left_c = c - side;

                    sum += d1[right_r][right_c];
                    if(top_r-1 >= 0 && top_c-1 >= 0){
                        sum -= d1[top_r-1][top_c-1];
                    }

                    sum += d2[bottom_r][bottom_c];
                    if(right_r-1 >= 0 && right_c+1 < n){
                        sum -= d2[right_r-1][right_c+1];
                    }

                    sum +=  d1[bottom_r][bottom_c];
                    if(left_r-1 >= 0 && left_c-1 >= 0){
                        sum -= d1[left_r-1][left_c-1];
                    }

                    sum += d2[left_r][left_c];
                    if(top_r-1 >= 0 && top_c+1 < n){
                        sum -= d2[top_r-1][top_c+1];
                    }

                    sum -= grid[top_r][top_c];
                    sum -= grid[right_r][right_c];
                    sum -= grid[bottom_r][bottom_c];
                    sum -= grid[left_r][left_c]; 

                    setAdd(set, sum);
                }
            }
        }

        int[] result = new int[Math.min(3, set.size())];

        int i = 0;
        while(!set.isEmpty() && i < 3){
            result[i] = set.pollFirst();
            i++;
        }

        return result;
    }
}