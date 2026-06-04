// T.C: O(Range(num1, num2) * (log(range)))
// S.C: O(1)
class Solution {
    int wavince(int num){
        char[] numChar = String.valueOf(num).toCharArray();
        if(numChar.length <= 2) return 0;

        int cnt = 0;

        for(int i = 1; i < numChar.length-1; i++){
            if(numChar[i-1] < numChar[i] && numChar[i] > numChar[i+1]){
                cnt++;
            }
            else if(numChar[i-1] > numChar[i] && numChar[i] < numChar[i+1]){
                cnt++;
            }
        }
        return cnt;
    }
    public int totalWaviness(int num1, int num2) {
        int result = 0;

        for(int i = Math.min(num1, num2); i <= Math.max(num1, num2); i++){
            result += wavince(i);
        }

        return result;
    }
}