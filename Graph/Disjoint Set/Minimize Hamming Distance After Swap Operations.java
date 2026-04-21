//Approach - (DSU + map)
//T.C : O(n + m*alpha(n)), alpha(n) = inverse Ackermann function.
//S.C : O(n)
class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        int parent_x = find(x);
        int parent_y = find(y);

        if(parent_x == parent_y) return;

        if(rank[parent_x] > rank[parent_y]){
            parent[parent_y] = parent_x;
        }
        else if(rank[parent_x] < rank[parent_y]){
            parent[parent_x] = parent_y;
        }
        else{
            parent[parent_x] = parent_y;
            rank[parent_y]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        int n = source.length;

        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int[] val : allowedSwaps){
            union(val[0], val[1]);
        }

        Map<Integer, Map<Integer, Integer>> groupFreq = new HashMap<>();

        for(int i = 0; i < n; i++){
            int curr = source[i];

            int parent = find(i);
            groupFreq.computeIfAbsent(parent, k-> new HashMap<>());
            Map<Integer, Integer> freqMap = groupFreq.get(parent);
            freqMap.put(curr, freqMap.getOrDefault(curr, 0)+1);
        }

        int hammingDistance = 0;

        for(int i = 0; i < n; i++){
            int parent = find(i);
            Map<Integer, Integer> freqMap = groupFreq.get(parent);

            if(freqMap.getOrDefault(target[i], 0) > 0){
                freqMap.put(target[i], freqMap.get(target[i]) - 1);
            }
            else{
                hammingDistance++;
            }
        }

        return hammingDistance;
        
    }
}