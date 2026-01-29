// Approach: For each cell in the board, start a DFS/backtracking search
// to try to match the word. From a cell that matches the current character,
// temporarily mark it as visited, then explore its 4 neighbors (up, down,
// left, right) for the next character. Backtrack by restoring the cell after
// exploring. If we consume all characters of the word, return true.
// T.C: O(M * N * 4^L) in the worst case, where M, N are board dimensions
// and L is the word length, since from each cell we branch in up to 4
// directions for each character.
// S.C: O(L) for recursion stack depth and O(1) extra memory beyond the
// input board and word (we mark cells in-place).
class Solution {
    int[][] direction = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    int N;
    int M;
    
    boolean isValid(int row, int col){
        return row >= 0 && col >= 0 && row < M && col < N;
    }

    boolean fun(int row, int col, char[][] board, String word, int idx){
        if(idx == word.length()) return true;

        if(!isValid(row, col) || board[row][col] != word.charAt(idx)){
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '_';
        for(int i = 0; i < 4; i++){
            int[] dir = direction[i];
            int r_new = row + dir[0];
            int c_new = col + dir[1];

            if(fun(r_new, c_new, board, word, idx+1)){
                return true;
            }
        }

        board[row][col] = temp;

        return false;
    }
    public boolean exist(char[][] board, String word) {
        M = board.length;
        N = board[0].length; 
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(fun(i,j, board, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
}