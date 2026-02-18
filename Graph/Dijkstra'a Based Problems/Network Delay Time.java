// T.C: O(V + E)
// S.C: O(V)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));

        int[] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        pq.add(new int[]{0, k});
        result[k] = 0;

        while(!pq.isEmpty()){
            int[] temp = pq.poll();

            int d = temp[0];
            int node = temp[1];

            for(int[] vec : adj.get(node)){
                int adjNode = vec[0];
                int wt = vec[1];

                if(d+wt < result[adjNode]){
                    result[adjNode] = d+wt;
                    pq.add(new int[]{d+wt, adjNode});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            int num = result[i];
            ans = Math.max(ans, num);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}