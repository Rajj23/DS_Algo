// Approach 1(using prefix and suffix sum)
// T.C: O(n)
// S.C: O(2n)
class Solution {
    public int bestClosingTime(String customers){
        int n = customers.length();

        int[] prefixN = new int[n+1];
        prefixN[0] = 0;

        int[] suffixY = new int[n+1];
        suffixY[n] = 0;

        for(int i=1;i<=n;i++){
            if(customers.charAt(i-1)=='N'){
                prefixN[i] = prefixN[i-1] + 1;
            }
            else{
                prefixN[i] = prefixN[i-1];
            }
        }

        for(int i=n-1;i>=0;i--){
            if(customers.charAt(i)=='Y'){
                suffixY[i] = suffixY[i+1] + 1;
            }else{
                suffixY[i] = suffixY[i+1];
            }
        }

        int minPenalty = Integer.MAX_VALUE;
        int minHour = Integer.MAX_VALUE;

        for(int i=0;i<=n;i++){
            int currPenalty = prefixN[i] + suffixY[i];

            if(currPenalty<minPenalty){
                minPenalty = currPenalty;
                minHour = i;
            }
        }
        return minHour;
    }
}


// Approach 2(using count)
// T.C: O(2n)
// S.C: O(1)
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int totalY = 0;
        int prevN = 0, prevY = 0;
        int penalty = Integer.MAX_VALUE;
        int result = 0;

        for(char ch:customers.toCharArray()){
            if(ch=='Y'){
                totalY++;
            }
        }

        penalty = totalY;
        result = 0;

        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y'){
                prevY++;
            }
            else{
                prevN++;
            }

            int currPenalty = (totalY-prevY) + prevN;
            if(currPenalty<penalty){
                penalty = currPenalty;
                result = i+1;
            }
        }
        return result;
    }
}