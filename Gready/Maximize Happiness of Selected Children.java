// Approach - 1 (using sorting)
// T.C: O(nlogn)
// S.C: O(1)
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long sum = 0;
        for(int i=0;i<k;i++){
            int happines = Math.max(0,happiness[n-i-1]-i);
            sum += happines;
        }
        return sum;
    }
}

// Approach - 2 (using priorityqueue    )
// T.C: O(nlogn)
// S.C: O(n)
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long result = 0;
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int hap:happiness){
            pq.add(hap);
        }

        for(int i=0;i<k;i++){
            int hap = pq.poll();
            
            result += Math.max(hap-count,0);
            count++;
        }

        return result;
    }
}