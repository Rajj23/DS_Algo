//T.C : O(vlogv + hlogh), v = vBars.size(), h = hBars.size()
//S.C : O(1)
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxConsicutiveHBars = 1;
        int maxConsicutiveVBars = 1;

        int currConsicutiveHBars = 1;
        for(int i = 1; i < hBars.length; i++){
            if(hBars[i] - hBars[i-1] == 1){
                currConsicutiveHBars++;
            }
            else{
                currConsicutiveHBars = 1;
            }
            maxConsicutiveHBars = Math.max(maxConsicutiveHBars, currConsicutiveHBars);
        }

        int currConsicutiveVBars = 1;
        for(int i = 1; i < vBars.length; i++){
            if(vBars[i] - vBars[i-1] == 1){
                currConsicutiveVBars++;
            }
            else{
                currConsicutiveVBars = 1;
            }
            maxConsicutiveVBars = Math.max(maxConsicutiveVBars, currConsicutiveVBars);
        }

        int size = Math.min(maxConsicutiveHBars, maxConsicutiveVBars) + 1;

        return size * size;
    }
}   