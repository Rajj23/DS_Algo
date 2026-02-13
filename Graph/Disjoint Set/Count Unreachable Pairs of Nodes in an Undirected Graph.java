class Solution {
    int[] parent;
    int[] rank;

    int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent) return;

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
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }


        for(int[] e : edges){
            union(e[0], e[1]);
        }

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            int x_parent = find(i);

            mp.put(x_parent, mp.getOrDefault(x_parent, 0)+1);
        }

        int remain = n;
        long result = 0;
        for(int size : mp.values()){
            result += (long)size * (remain - size);

            remain -= size;
        }

        return result;
    }
}