// T.C: O(V + E)
// S.C: O(V + E)
class Solution {
    int dfs(int node, List<List<Integer>> adj, List<Boolean> hasApple, int parent) {
        int total = 0;
        for (int nbr : adj.get(node)) {
            if (nbr == parent)
                continue;

            total += dfs(nbr, adj, hasApple, node);
        }

        if (node != 0 && (hasApple.get(node) || total > 0)) {
            total += 2;
        }

        return total;

    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(0, adj, hasApple, -1);
    }
}