// T.C: O(n)
// S.C: O(n)
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        Queue<int[]> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mp.computeIfAbsent(arr[i], k-> new ArrayList<>()).add(i);
        }

        que.add(new int[]{0, 0});
        visited[0] = true;

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int idx = curr[0];
            int step = curr[1];

            if(idx == n-1) return step;

            if(idx-1 >= 0 && !visited[idx-1]){
                que.add(new int[]{idx-1, step+1});
                visited[idx-1] = true;
            }

            if(idx+1 < n && !visited[idx+1]){
                que.add(new int[]{idx+1, step+1});
                visited[idx+1] = true;
            }
            if(mp.get(arr[idx]) != null){
                for(int addIdx : mp.get(arr[idx])){
                    if(!visited[addIdx]){
                        que.add(new int[]{addIdx, step+1});
                        visited[addIdx] = true;
                    }
                }
                mp.remove(arr[idx]);
            }
        }

        return -1;
    }
}