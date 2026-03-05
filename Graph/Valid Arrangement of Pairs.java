// T.C: O(V + E)
// S.C: O(V + E)
class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = pairs.length;

        Map<Integer, Integer> indegree = new HashMap<>();       
        Map<Integer, Integer> outdegree = new HashMap<>();       
        for(int[] pair : pairs){
            int u = pair[0];
            int v = pair[1];
            adj.computeIfAbsent(u, k-> new ArrayList<>()).add(v);

            indegree.put(v, indegree.getOrDefault(v, 0)+1);  
            outdegree.put(u, outdegree.getOrDefault(u, 0)+1);          
        }

        int start = pairs[0][0];
        for(int node : adj.keySet()){
            if(outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1){
                start = node;
                break;
            }
        }

        List<Integer> eulerPath = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(start);

        while(!st.isEmpty()){
            int curr = st.peek();

            if(adj.containsKey(curr) && !adj.get(curr).isEmpty()){
                int neighbor = adj.get(curr).remove(adj.get(curr).size() - 1);
                st.push(neighbor);
            }
            else{
                eulerPath.add(st.pop());
            }
        }

        Collections.reverse(eulerPath);
        int[][] result = new int[eulerPath.size() - 1][2];
        for(int i = 0; i < eulerPath.size() - 1; i++){
            result[i][0] = eulerPath.get(i);
            result[i][1] = eulerPath.get(i+1);
        }

        return result;
    }
}