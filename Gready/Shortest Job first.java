// ***************************************************************** JAVA *****************************************************

// T.C: O(n + nlongn)
// S.C: O(1)
class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        
        int n = bt.length;
        int wt = 0;
        int t = 0;
        
        for(int b:bt){
            wt += t;
            
            t +=b;
        }
        return wt/n;
    }
}
