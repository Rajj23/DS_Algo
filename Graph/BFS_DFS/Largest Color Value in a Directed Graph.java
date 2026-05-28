// T.C: O(V + E)
// S.C: O(26 * n)
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        int n = colors.length();
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> que = new ArrayDeque<>();
        int[][] t = new int[n][26];

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                que.add(i);
                t[i][colors.charAt(i)-'a'] = 1;
            }
        }

        int ans = 0;
        int countNodes = 0;

        while(!que.isEmpty()){
            int u = que.poll();

            countNodes++;

            ans = Math.max(ans, t[u][colors.charAt(u)-'a']);

            for(int v : adj.get(u)){

                for(int i = 0; i < 26; i++){
                    t[v][i] = Math.max(t[v][i], t[u][i] + ((colors.charAt(v) - 'a' == i) ? 1 : 0));
                }
                
                indegree[v]--;
                if(indegree[v] == 0){
                    que.add(v);
                }
            }

        }

        if(countNodes < n) return -1;

        return ans;
    }
}