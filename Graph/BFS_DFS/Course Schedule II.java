// T.C: O(V + E)
// S.C: O(V)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] e : prerequisites){
            int u = e[1];
            int v = e[0];

            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!que.isEmpty()){
            int u = que.poll();
            list.add(u);

            for(int v : adj.get(u)){
                indegree[v]--;

                if(indegree[v] == 0){
                    que.add(v);
                }
            }
        }

        if(list.size() == numCourses){
           int[] result = new int[numCourses];
           int i = 0;
           for(int num : list){
            result[i++] = num;
           }

           return result;
        }

        return new int[]{};
    }
}