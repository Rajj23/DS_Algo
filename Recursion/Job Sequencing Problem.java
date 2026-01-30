// Approach: Greedy + DSU (disjoint set) over time slots.
// Build (deadline, profit) pairs and sort by profit in descending order.
// For each job, use DSU `find` to get the latest free slot ≤ its deadline;
// if a slot exists, schedule the job there and union this slot with the
// previous one to mark it occupied.
//
// Time Complexity: O(n log n + n * α(D)) ≈ O(n log n),
//   where n is the number of jobs and D is the maximum deadline.
// Space Complexity: O(D) for the parent array used by DSU.
class Solution {
    int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        int[][] seq = new int[n][2];
        
        int maxDeadLine = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            seq[i][0] = deadline[i];
            seq[i][1] = profit[i];
            
            maxDeadLine = Math.max(maxDeadLine, deadline[i]);
        }   
        
        Arrays.sort(seq, (a, b) -> b[1] - a[1]);
        
        int[] parent = new int[maxDeadLine+1];
        for(int i = 0; i <= maxDeadLine; i++){
            parent[i] = i;
        }
        
        int profitEarn = 0;
        int count = 0;
        
        boolean isPlaced = true;
        
        for(int i = 0; i < n; i++){
            int d = seq[i][0];
            int p = seq[i][1];
            
            int freeSlot = find(d, parent);

            if (freeSlot > 0) {
                parent[freeSlot] = find(freeSlot - 1, parent);
                count++;
                profitEarn += p;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(profitEarn);
        
        return result;
    }
}