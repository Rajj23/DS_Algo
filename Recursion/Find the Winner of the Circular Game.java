// Approach 1 (Simulation with Queue): Put players 1..n into a queue.
// Repeatedly rotate the queue k-1 times by moving the front element
// to the back, then remove (poll) the k-th player. The last remaining
// player in the queue is the winner.
// T.C: O(n * k) in the worst case, since for each of the (n-1)
// eliminations we perform up to (k-1) queue operations.
// S.C: O(n) for the queue storing all players.
class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        while(q.size() > 1){
            int i = 0;
            while(i < k-1){
                q.add(q.poll());
                i++;
            }
            q.poll();
        }

        return q.poll();
    }
}


// Approach 2 (Josephus recursion / math): Use the recursive Josephus
// relation f(n, k) = (f(n-1, k) + k) % n with base case f(1, k) = 0
// to compute the 0-based index of the winner. Convert the result to
// 1-based by adding 1.
// T.C: O(n), because we compute the recurrence once for each size
// from 1 to n.
// S.C: O(n) due to the recursion stack depth (or O(1) if converted
// to an iterative loop using the same recurrence).
class Solution {
    int find(int n, int k){
        if(n == 1) return 0;

        int idx = find(n-1, k);
        idx = (idx + k) %n;

        return idx;
    }
    public int findTheWinner(int n, int k) {
        int res_idx = find(n, k);
        return res_idx+1;
    }
}