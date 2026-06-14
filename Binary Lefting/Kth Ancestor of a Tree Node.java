//Approach (Using Binary Lifting)
//T.C : O(Q * log(n)) , Q = number of queries , n = number of nodes
//S.C : O(n * log(n)) to store events in map
class TreeAncestor {
    int[][] ancestorTable;
    int rows;
    int cols; 

    public TreeAncestor(int n, int[] parent) {
        rows = n;
        cols = (int) (Math.log(n) / Math.log(2)) + 1;

        ancestorTable = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            Arrays.fill(ancestorTable[i], -1);
        }

        for(int node = 0; node < n; node++){
            ancestorTable[node][0] = parent[node];
        }

        for(int j = 1; j < cols; j++){
            for(int node = 0; node < n; node++){

                if(ancestorTable[node][j-1] != -1)
                    ancestorTable[node][j] = ancestorTable[ancestorTable[node][j-1]][j-1];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int j = 0; j < cols && node != -1; j++){
            if((k & (1 << j)) != 0){
                node = ancestorTable[node][j];

                if(node == -1) return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */