// Approach: rec + memo
// T.C: O(n)
// S.C: O(n)
class Solution {
    int[][][] t;

    int toIdx(char c){
        return c == '0' ? 26 : c - 'A';
    }

    int solve(int idx, char prevP1, char prevP2, String word){
        int n = word.length();
        if(idx >= n){
            return 0;
        }

        int i1 = toIdx(prevP1);
        int i2 = toIdx(prevP2);

        if(t[idx][i1][i2] != Integer.MAX_VALUE) 
            return t[idx][i1][i2];

        char ch = word.charAt(idx);
        int x = (ch - 'A') / 6;
        int y = (ch - 'A') % 6;

        int dist1 = 0;
        if(prevP1 != '0'){
            int x1 = (prevP1 - 'A') / 6;
            int y1 = (prevP1 - 'A') % 6;
            dist1 = Math.abs(x1 - x) + Math.abs(y1 - y);
        }

        int first = dist1 + solve(idx+1, ch, prevP2, word);

        int dist2 = 0;
        if(prevP2 != '0'){
            int x2 = (prevP2 - 'A') / 6;
            int y2 = (prevP2 - 'A') % 6;
            dist2 = Math.abs(x2 - x) + Math.abs(y2 - y);
        }

        int sec = dist2 + solve(idx+1, prevP1, ch, word);

        return t[idx][i1][i2] = Math.min(first, sec);

    }

    public int minimumDistance(String word) {
        int n = word.length();
        t = new int[n+1][27][27];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < 27; j++){
                Arrays.fill(t[i][j], Integer.MAX_VALUE);
            }
        }
        return solve(0, '0', '0', word);
    }
}

// Approach: bottom-up
// T.C: O(n)
// S.C: O(n)
class Solution {
    int dist(int d1, char ch) {
        if (d1 == 26)
            return 0;
        int x1 = d1 / 6;
        int y1 = d1 % 6;

        int x2 = (ch - 'A') / 6;
        int y2 = (ch - 'A') % 6;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int minimumDistance(String word) {
        int n = word.length();

        int[][] t = new int[n + 1][27];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(t[i], Integer.MAX_VALUE);
        }
        t[0][26] = 0; 

        for (int i = 0; i <= n - 2; i++) {
            for (int j = 26; j >= 0; j--) {
                if(t[i][j] == Integer.MAX_VALUE) continue;
                char last = word.charAt(i);
                char ch = word.charAt(i + 1);

                t[i + 1][j] = Math.min(t[i+1][j], t[i][j] + dist(last - 'A', ch));

                t[i+1][last - 'A'] = Math.min(t[i+1][last - 'A'], t[i][j] + dist(j, ch));
            }
        }
        int res = Integer.MAX_VALUE;
        for(int j = 0; j <= 26; j++){
            res = Math.min(res, t[n-1][j]);
        }

        return res;
    }
}