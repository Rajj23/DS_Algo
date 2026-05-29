// T.C: O(n)
// S.C: O(n)
class Solution {
    int[] t;
    int f(int n){
        if(n <= 1) return n;
        
        if(t[n] != -1) return t[n];
        
        t[n-1] = f(n-1);
        t[n-2] = f(n-2);
        
        
        return t[n-1] + t[n-2];
    }
    public int nthFibonacci(int n) {
        // code here
        t = new int[n+1];
        if(n <= 1) return n;
        
        Arrays.fill(t, -1);
        
        t[0] = 0;
        t[1] = 1;
        
        return f(n);
    }
}