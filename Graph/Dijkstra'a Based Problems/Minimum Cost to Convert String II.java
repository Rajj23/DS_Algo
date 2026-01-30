//Approach (Using Dijkstra's Algorithm and DP with Power of Memoization for both)
/*
N = length of sourceStr / targetStr
M = number of conversion rules (original.size())
L = number of distinct substring lengths
(L = lengthSet.size())
V = number of unique strings appearing in original and changed
E = number of edges in graph (E = M)
T.C : O(
          M                           // graph build
          + M log L                     // lengthSet
          + N² × L                      // DP overhead
          + M² × (V + E) log V          // Dijkstra
        )
  S.C : O(M² + V + E + N)
*/
class Solution {
    class Pair{
        long cost;
        String node;

        Pair(long cost, String node){
            this.cost = cost;
            this.node = node;
        }
    }

    long BIG_VALUE = (long) 1e10;

    Map<String, List<Pair>> adj = new HashMap<>();

    long[] dpMemo;

    String sourceStr;
    String targetStr;
    Set<Integer> validLengths = new TreeSet<>();

    Map<String, Map<String, Long>> dijkstraMemo = new HashMap<>();

    long dijkstra(String start, String end){

        if(dijkstraMemo.containsKey(start) &&
            dijkstraMemo.get(start).containsKey(end)){
                return dijkstraMemo.get(start).get(end);
            }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingLong(p -> p.cost));
        
        Map<String, Long> result = new HashMap<>();

        result.put(start, 0L);
        pq.offer(new Pair(0, start));

        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            long currCost = temp.cost;
            String node = temp.node;

            if(node == end) break;

            if(!adj.containsKey(node)) continue;

            for(Pair edge : adj.get(node)){
                String adjNode = edge.node;
                long edgeCost = edge.cost;

                if(!result.containsKey(adjNode) || currCost + edgeCost < result.get(adjNode)){
                    result.put(adjNode, currCost + edgeCost);
                    pq.offer(new Pair(currCost + edgeCost, adjNode));
                }
            }
        }
        long finalCost = result.containsKey(end) ? result.get(end) : BIG_VALUE;

        dijkstraMemo
            .computeIfAbsent(start, k -> new HashMap<>())
            .put(end, finalCost);

        return finalCost;
    }

    long solve(int idx){
        if(idx >= sourceStr.length()){
            return 0;
        }

        long minCost = BIG_VALUE;

        if(dpMemo[idx] != -1){
            return dpMemo[idx];
        }

        if(sourceStr.charAt(idx) == targetStr.charAt(idx))
            minCost = solve(idx+1);

        for(int len : validLengths){
            if(idx + len > sourceStr.length()){
                break;
            }

            String srcSub = sourceStr.substring(idx, idx+len);
            String tgtSub = targetStr.substring(idx, idx+len);

            if(!adj.containsKey(srcSub)){
                continue;
            }

            long minPathCost = dijkstra(srcSub, tgtSub);
            if(minPathCost == BIG_VALUE)
                continue;

            minCost = Math.min(minCost, minPathCost + solve(idx+len));
        }   

        return dpMemo[idx] = minCost;

    }

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        
        sourceStr = source;
        targetStr = target;

        dpMemo = new long[10001];
        Arrays.fill(dpMemo, -1);

        for(int i = 0; i < original.length; i++){
            adj.computeIfAbsent(original[i], k -> new ArrayList<>())
            .add(new Pair(cost[i], changed[i]));
            validLengths.add(original[i].length());
        }

        long result = solve(0);

        return result == BIG_VALUE ? -1 : result;
    }
}