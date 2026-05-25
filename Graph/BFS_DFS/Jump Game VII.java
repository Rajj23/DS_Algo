// T.C: O(n)
// S.C: O(n)
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];

        que.add(0);
        visited[0] = true;

        int farthest = 0;

        while(!que.isEmpty()){
            int idx = que.poll();

            int start = Math.max(idx+minJump, farthest+1);
            int end = Math.min(idx+maxJump, n-1);

            for(int i = start; i <= end; i++){

                if(s.charAt(i) == '0' && !visited[i]){

                    if(i == n-1) return true;

                    que.add(i);
                    visited[i] = true;
                }
            }
            farthest = end;
        }
        return n==1;
    }
}