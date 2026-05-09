// T.C: O(n)
// S.C: O(1)
class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0, cnt = 0;
        int n = events.length;

        for(int i = 0; i < n; i++){
            if(cnt == 10) break;
            if(events[i].equals("W")){
                cnt++;
            }
            else if(events[i].equals("WD") || events[i].equals("NB")){
                score++;
            }
            else{
                score += Integer.parseInt(events[i]);
            }
        }
        int[] result = {score, cnt};
        return result;
    }
}