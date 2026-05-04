// Approach: Using HashMap
// T.C: O(nlogk)
// S.C: O(k)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        int i = 0, j = 0;
        while(j < n && j < k){
            mp.put(nums[j], mp.getOrDefault(nums[j], 0)+1);
            j++;
        }

        int[] result = new int[n-k+1];

        while(j < n){
            result[i] = mp.lastKey();
            mp.put(nums[i], mp.get(nums[i])-1);
            if(mp.get(nums[i]) == 0){
                mp.remove(nums[i]);
            }
            mp.put(nums[j], mp.getOrDefault(nums[j], 0)+1);
            i++;
            j++;
        }
        result[i] = mp.lastKey();
        return result;
    }
}

// Approach: Using Deque
// T.C: O(2n)
// S.C: O(n)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] result = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++){

            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.addLast(i);
            if(i >= k - 1){
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}