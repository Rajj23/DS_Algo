// T.C: O(n)
// S.C: O(n)
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] visited = new boolean[n];
        
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int idx = que.poll();

            if(arr[idx] == 0) return true;

            int right = idx + arr[idx];
            if(right < n && !visited[right]){
                que.add(right);
                visited[right] = true;
            }

            int left = idx - arr[idx];
            if(left >= 0 && !visited[left]){
                que.add(left);
                visited[left] = true;
            }
        }        
        return false;
    }
}