// Approach: 1
// T.C: O(V + E * m)
// S.C: O(V)
class Solution {
    int[] parent;
    int[] rank;

    int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }


    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        rank = new int[n];

        int m = queries.length;

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int i = 0; i < n-1; i++){
            if(nums[i+1] - nums[i] <= maxDiff){
                union(i, i+1);
            }
        }

        boolean[] result = new boolean[m];

        for(int i = 0; i < m; i++){
            int[] query = queries[i];
            int x = query[0];
            int y = query[1];

            int x_parent = find(x);
            int y_parent = find(y);

            if(x_parent == y_parent){
                result[i] = true;
            }
        }

        return result;
    }
}

// Approach: 2
// T.C: O(max(m, n))
// S.C: O(n)
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int m = queries.length;

        int comp = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i-1] > maxDiff){
                comp++;
            }
            component[i] = comp;
        }

        boolean[] result = new boolean[m];

        for(int i = 0; i < m; i++){
            int start = queries[i][0];
            int end = queries[i][1];

            if(component[start] == component[end]){
                result[i] = true;
            }
        }

        return result;
    }
}