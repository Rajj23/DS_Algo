// ************************************************************************* JAVA ********************************************************************

// Approach 1
// T.C: O(N*N)
// S.C: O(N)
class Solution {
    int n;
    int M = 1_000_000_007;
    long[] t = new long[50000+1];
    private long solve(int i,int[] nums,int k){
        if(i>=n){
            return 1;
        }

        if(t[i]!=-1){
            return t[i];
        }

        long count = 0;
        int minEl = Integer.MAX_VALUE;
        int maxEl = Integer.MIN_VALUE;

        for(int j=i;j<n;++j){
            minEl = Math.min(minEl,nums[j]);
            maxEl = Math.max(maxEl,nums[j]);

            if(maxEl-minEl > k){
                break;
            }
            count = (count + solve(j+1,nums,k)) % M;
        }
        t[i] = count;
        return count;
    }
    public int countPartitions(int[] nums, int k) {
        n = nums.length;
        for(int i=0;i<50000+1;i++){
            t[i] = -1;
        }
        return (int)solve(0,nums,k);
    }
}

// Approach 2
// T.C: O(N*N)
// S.C: O(N)
class Solution {
    int n;
    int M = 1_000_000_007;
    long[] t = new long[50000+1];
    public int countPartitions(int[] nums, int k){

        int n = nums.length;
        t[n] = 1;

        for(int i=n-1;i>=0;--i){
            long count = 0;
            int minEl = Integer.MAX_VALUE;
            int maxEl = Integer.MIN_VALUE;

            for(int j=i;j<n;j++){
                minEl = Math.min(minEl,nums[j]);
                maxEl = Math.max(maxEl,nums[j]);

                if(maxEl - minEl > k){
                    break;
                }

                count = (count+t[j+1]) % M;
            }

            t[i] = count;
        }
        return (int)t[0];
    }
}


// Approach 3
// T.C: O(N)
// S.C: O(N)
class Solution {
    public int countPartitions(int[] nums, int k){
        int n = nums.length;
        int M = 1_000_000_007;

        long[] dp = new long[n+1];
        long[] pref = new long[n+1];

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int i=0,j=0;

        while(j<n){

            while(!maxDeque.isEmpty() && nums[j] > nums[maxDeque.peekLast()]){
                maxDeque.pollLast();
            }
            maxDeque.addLast(j);

            while(!minDeque.isEmpty() && nums[j] < nums[minDeque.peekLast()]){
                minDeque.pollLast();
            }
            minDeque.addLast(j);

            while(nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k){
                i++;
                if(!maxDeque.isEmpty() && maxDeque.peekFirst() < i){
                    maxDeque.pollFirst();
                }
                if(!minDeque.isEmpty() && minDeque.peekFirst() < i){
                    minDeque.pollFirst();
                }
            }

            long val = (pref[j] - (i > 0 ? pref[i-1] : 0)+M) % M;
            dp[j+1] = val;
            pref[j+1] = (pref[j] + dp[j+1]) %M;

            j++;
        }

        return (int) dp[n];
    }
}