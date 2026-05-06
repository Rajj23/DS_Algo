//Approach-1 (Brute Force)
//T.C : O(col * row * row)
//S.C : O(1) - Not considering the space of result
class Solution {
    void reverse(char[] grid){
        int i = 0, j = grid.length-1;

        while(i < j){
            char temp = grid[i];
            grid[i] = grid[j];
            grid[j] = temp;
            i++;
            j--;
        }
    }
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        char[][] result = new char[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[i][j] = box[j][i];
            }
        }

        for(int i = 0; i < n; i++){
            reverse(result[i]);
        }

        for(int j = 0; j < m; j++){
            for(int i = n-1; i >= 0; i--){
                if(result[i][j] == '.'){
                    int stoneRow = -1;

                    for(int k = i-1; k >= 0; k--){
                        if(result[k][j] == '*'){
                            break;
                        }
                        else if(result[k][j] == '#'){
                            stoneRow = k;
                            break;
                        }
                    }
                    if(stoneRow != -1){
                        result[i][j] = '#';
                        result[stoneRow][j] = '.';
                    }
                }
            }
        }
        return result;
    }
}


//Approach-3 (better)
//T.C : O(col * (2 *row) )
//S.C : O(1) - Not considering the space of result
class Solution {
    void reverse(char[] grid){
        int i = 0, j = grid.length-1;

        while(i < j){
            char temp = grid[i];
            grid[i] = grid[j];
            grid[j] = temp;
            i++;
            j--;
        }
    }
    public char[][] rotateTheBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            int stone = 0;
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '#'){
                    grid[i][j] = '.';
                    stone++;
                }
                else if(grid[i][j] == '*'){
                    int k = j-1;
                    while(stone > 0){
                        grid[i][k] = '#';
                        stone--;
                        k--;
                    }
                }
            }
            int k = n-1;
            while(stone > 0){
                grid[i][k] = '#';
                stone--;
                k--;
            }
        }

        char[][] result = new char[n][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[j][i] = grid[i][j];
            }
        }
        
        for(int i = 0; i < n; i++)
            reverse(result[i]);

        return result;
    }
}


//Approach-3 (Optimized)
//T.C : O(col * row)
//S.C : O(1) - Not considering the space of result
class Solution {
    void reverse(char[] grid){
        int i = 0, j = grid.length-1;

        while(i < j){
            char temp = grid[i];
            grid[i] = grid[j];
            grid[j] = temp;
            i++;
            j--;
        }
    }
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        char[][] result = new char[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[i][j] = box[j][i];
            }
        }

        for(int i = 0; i < n; i++){
            reverse(result[i]);
        }

        for(int j = 0; j < m; j++){
            int stoneRow = n-1;
            for(int i = n-1; i >= 0; i--){
                if(result[i][j] == '*'){
                    stoneRow = i-1;
                    continue;
                }

                if(result[i][j] == '#'){
                    result[i][j] = '.';
                    result[stoneRow][j] = '#';
                    stoneRow--;
                }
            }
        }
        return result;
    }
}