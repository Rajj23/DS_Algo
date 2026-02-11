class Solution {
    int[] parent;
    int[] rank;

    int find(int x){
        if(parent[x] == x){
            return x;
        }

        return find(parent[x]);
    }

    void Union(int x, int y){
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
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];

        for(int i = 0; i < 26; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(String eq : equations){
            int x = eq.charAt(0) - 'a';
            int y = eq.charAt(3) - 'a';

            char sign = eq.charAt(1);

            if(sign == '!') continue;

            Union(x, y);            
        }

        for(String eq : equations){
            int x = eq.charAt(0) - 'a';
            int y = eq.charAt(3) - 'a';

            char sign = eq.charAt(1);

            if(sign != '!') continue;

            int x_parent = find(x);
            int y_parent = find(y);

            if(x_parent == y_parent) return false;            
        }

        return true;
    }
}