// Approach: BFS
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

// Approach: Optimised BFS
// T.C: O(n)
// S.C: O(1)
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);

        while(!que.isEmpty()){
            int idx = que.poll();

            if(arr[idx] == 0) return true;

            arr[idx] *= -1;

            int right = idx + arr[idx];
            if(right < n && arr[right] >= 0){
                que.add(right);
            }

            int left = idx - arr[idx];
            if(left >= 0 && arr[left] >= 0){
                que.add(left);
            }
        }        
        return false;
    }
}


// Approach: DFS
// T.C: O(n)
// S.C: O(1)
class Solution {
    int n;
    boolean dfs(int[] arr, int i){
        if(i < 0 || i >= n || arr[i] < 0) return false;

        if(arr[i] == 0) return true;

        arr[i] *= -1;

        return dfs(arr, i-arr[i]) || dfs(arr, i+arr[i]);
    }
    public boolean canReach(int[] arr, int start) {
        n = arr.length;
        
        return dfs(arr, start);
    }
}