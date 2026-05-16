// T.C: O(V+E)
// S.C: O(V+E)
class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int ans = Math.abs(start[0] - target[0]) +
                    Math.abs(start[1] - target[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return Integer.compare(a[2], b[2]);
        });
        pq.add(new int[]{start[0], start[1], 0});
        Map<String, Integer> dist = new HashMap<>();
        dist.put(start[0] + "_" + start[1], 0);

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int x = curr[0];
            int y = curr[1];
            int wt = curr[2];

            String key = x + "_" + y;
            if(wt > dist.get(key)) continue;

            int cost = Math.abs(target[0] - x) + Math.abs(target[1] - y);
            ans = Math.min(ans, wt+cost);

            for(int[] road : specialRoads){
                int stX = road[0];
                int stY = road[1];
                int eX = road[2];
                int eY = road[3];
                int specialCost = road[4];

                int moveCost = Math.abs(x - stX) + Math.abs(y - stY);

                int newCost = wt + moveCost + specialCost;

                String nextKey = eX + "_" + eY;

                if(!dist.containsKey(nextKey) ||
                newCost < dist.get(nextKey)) {
                    dist.put(nextKey, newCost);
                    pq.add(new int[]{eX, eY, newCost});
                }
            }
        }
        return ans;
    }
}