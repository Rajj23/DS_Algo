// T.C: O(n)
// S.C: O(1)
class Solution {
    public boolean judgeCircle(String moves) {
        int upDown = 0;
        int leftRight = 0;

        for(char ch : moves.toCharArray()){
            if(ch == 'R'){
                leftRight++;
            }
            else if(ch == 'L'){
                leftRight--;
            }
            else if(ch == 'U'){
                upDown++;
            }
            else{
                upDown--;
            }
        }

        return leftRight == 0 && upDown == 0;
    }
}