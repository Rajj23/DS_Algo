class Solution {

    int[] parent;

    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = profit.length;
        int[][] jobs = new int[n][2];
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(b[1], a[1]));

        parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }

        int count = 0, totalProfit = 0;

        for (int[] job : jobs) {
            int availableSlot = find(job[0]);

            if (availableSlot > 0) {
                count++;
                totalProfit += job[1];
                parent[availableSlot] = availableSlot - 1; // union
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(totalProfit);
        return res;
    }
}
