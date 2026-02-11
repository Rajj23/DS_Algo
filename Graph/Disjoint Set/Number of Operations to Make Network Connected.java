// class Solution {
//     int[] parent;
//     int[] rank;

//     int find(int x) {
//         if (parent[x] == x) {
//             return x;
//         }

//         return parent[x] = find(parent[x]);
//     }

//     void union(int x, int y) {
//         int x_parent = find(x);
//         int y_parent = find(y);

//         if (x_parent == y_parent) {
//             return;
//         }

//         if (rank[x_parent] > rank[y_parent]) {
//             parent[y_parent] = x_parent;
//         } else if (rank[x_parent] < rank[y_parent]) {
//             parent[x_parent] = y_parent;
//         } else {
//             parent[y_parent] = x_parent;
//             rank[x_parent]++;
//         }
//     }

//     public int makeConnected(int n, int[][] connections) {
//         parent = new int[n];
//         rank = new int[n];

//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//             rank[i] = 1;
//         }

//         int extraCable = 0;

//         for (int[] connection : connections) {
//             int x = connection[0];
//             int y = connection[1];

//             int x_parent = find(x);
//             int y_parent = find(y);

//             if (x_parent == y_parent) {
//                 extraCable++;
//                 continue;
//             }

//             union(x, y);
//         }

//         int leftComp = 0;

//         for (int i = 0; i < n; i++) {
//             System.out.println(parent[i]);
//             if (find(i) == i) {
//                 leftComp++;
//             }
//         }

//         if (extraCable >= leftComp - 1)
//             return leftComp - 1;
//         return -1;

//     }
// }


class Solution {
    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent == y_parent) {
            return;
        }

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[y_parent] = x_parent;
            rank[x_parent]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(n - 1 > connections.length) return -1;

        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n ; i++){
            parent[i] = i;
        }

        int component = n;

        for(int[] con : connections){

            if(find(con[0]) != find(con[1])){
                union(con[0], con[1]);
                component--;
            }
        }

        return component - 1;
    }
}