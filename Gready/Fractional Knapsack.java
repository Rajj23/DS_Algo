// T.C: O(2n+nlogn)
// S.C: O(3n)
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n = val.length;
        double[][] comb = new double[n][3];
        
        for(int i=0;i<n;i++){
            comb[i][0] = (double)val[i]/wt[i];
            comb[i][1] = val[i];
            comb[i][2] = wt[i];
        }
        
        Arrays.sort(comb,(a,b) -> Double.compare(b[0], a[0]));
        
        double result = 0;
        
        for(int i=0;i<n;i++){
            if(capacity>=comb[i][2]){
                result += comb[i]+[1];
                capacity -= comb[i][2];
            }
            else{
                double weight = capacity/comb[i][2];
                result += (comb[i][1]*weight);
                capacity = 0;
            }
            
            if(capacity==0) break;
        }
        
        return result;
    }
}