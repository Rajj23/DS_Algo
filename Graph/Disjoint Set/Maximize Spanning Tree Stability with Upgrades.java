//Approach - (Binary Search + DSU)
//T.C : O(nlog(maxStability - minStability))
//S.C : O(n+e), n = number of nodes, e = number of edges
class DSU{
    int[] parent;
    int[] rank;

    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    boolean union(int x,int y){
        int parent_x = find(x);
        int parent_y = find(y);

        if(parent_x == parent_y) return false;

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

        return true;
    }
}

class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);        

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            int s = e[2];
            int m = e[3];

            if(m == 1){

                if(dsu.find(u) == dsu.find(v)){
                    return -1;
                }

                dsu.union(u, v);
            }
        }

        int result = -1;

        int low = 1;
        int high = (int) 2e5;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(n, edges, k, mid)){
                result = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return result;
    }

    boolean check(int n, int[][] edges, int k, int mid){
        DSU dsu = new DSU(n);

        List<int[]> upgradeCandidates = new ArrayList<>();

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            int s = e[2];
            int m = e[3];

            if(m == 1){
                if(s < mid){
                    return false;
                }
                dsu.union(u, v);
            }        
            else{
                if(s >= mid){
                    dsu.union(u, v);
                }
                else if(2*s >= mid){
                    upgradeCandidates.add(new int[]{u, v});
                }
                
            }
        }

        for(int[] e : upgradeCandidates){
            int u = e[0];
            int v = e[1];

            if(dsu.find(u) != dsu.find(v)){
                if(k <= 0){
                    return false;
                }

                dsu.union(u, v);
                k--;
            }
        }

        int root = dsu.find(0);
        for(int i = 1; i < n; i++){
            if(dsu.find(i) != root){
                return false;
            }
        }

        return true;
    }
}