// Approach:
// Use backtracking to place queens row by row on an n x n board.
// For each row, try all columns; before placing a queen at (row, col),
// check that no queen attacks it vertically or on either diagonal using the
// isValid helper. When row == n, build a string representation of the board
// and add it to the result list.
// T.C: O(n!) in the worst case: we try up to n choices in the first row,
// n-1 in the second, etc., with pruning from validity checks. Each isValid
// call scans up to O(n) cells, so the overall complexity is between
// O(n!) and O(n^2 * n!), commonly stated as O(n!).
// S.C: O(n^2) for the visited board plus O(n) recursion depth for the call
// stack; the result list itself uses additional space for all valid boards.
class Solution {

    boolean isValid(int row, int col, boolean[][] visited, int n){
        for(int i = row-1; i >=0; i--){
            if(visited[i][col]){
                return false;
            }
        }

        int i = row - 1;
        int j = col - 1;
        while(i >= 0 && j >= 0){
            if(visited[i][j]){
                return false;
            }
            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < n){
            if(visited[i][j]){
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
    void fun(int row, boolean[][] visited, int n, List<List<String>> result){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    sb.append(visited[i][j] ? "Q" : ".");
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }
        for(int col = 0; col < n; col++){
            if(isValid(row, col, visited, n)){
                visited[row][col] = true;
                fun(row+1, visited, n, result);
                visited[row][col] = false;
            }
        }   
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        fun(0,new boolean[n][n], n, result);
        return result;
    }
}