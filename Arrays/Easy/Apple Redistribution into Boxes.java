// T.C: O(nlogn + m)
// S.C: O(1)
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApple = 0;
        for(int a:apple){
            totalApple+=a;
        }

        int currCap = 0;
        int n = capacity.length;
        for(int i=0;i<n;i++){
            currCap += capacity[n-i-1];
            if(currCap>=totalApple){
                return i+1;
            }
        }
        return n;
    }
}