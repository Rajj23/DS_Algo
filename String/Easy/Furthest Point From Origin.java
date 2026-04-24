// Approach: Recursive(TLE)
// T.C: O(2^n)
// S.C: O(1)
class Solution {
    int max = 0;
    void solve(int idx, String moves, int pos){
        if(idx >= moves.length()){
            max = Math.max(max, Math.abs(pos));
            return;
        }

        int result = 0;
        if(moves.charAt(idx) == 'L'){
            solve(idx+1, moves, pos-1);
        }
        else if(moves.charAt(idx) == 'R'){
            solve(idx+1, moves, pos+1);
        }
        else{
            solve(idx+1, moves, pos-1);
            solve(idx+1, moves, pos+1);
        }
    }
    public int furthestDistanceFromOrigin(String moves) {
        solve(0, moves, 0);
        return max;
    }
}

// T.C: O(n)
// S.C: O(1)
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;
        int blank = 0;

        for(char ch : moves.toCharArray()){
            if(ch == 'L'){
                left++;
            }
            else if(ch == 'R'){
                right++;
            }
            else{
                blank++;
            }
        }
        return blank + Math.abs(right - left);
    }
}