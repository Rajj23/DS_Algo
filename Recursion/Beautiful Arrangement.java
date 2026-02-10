// T.C: O(n!)
// S.C: O(n)
class Solution {
    int count;
    void solve(int idx, int n, boolean[] visited){
        if(idx > n){
            count++;
            return;
        }
        
        for(int i = 1; i <= n; i++){
            if(!visited[i] && (i % idx == 0 || idx % i == 0)){
                visited[i] = true;
                solve(idx+1, n, visited);
                visited[i] = false;
            }
        }
    }
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        solve(1, n, visited);
        
        return count;
    }
}