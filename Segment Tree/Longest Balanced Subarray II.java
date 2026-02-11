//Approach-1 (Brute Force) - TLE
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        int[] cumSum = new int[n];

        int maxL = 0;

        Map<Integer,Integer> mp = new HashMap<>();

        for(int r = 0; r < n; r++){
            int val = (nums[r] % 2 == 0) ? 1 : -1;

            int prev = -1;
            if(mp.containsKey(nums[r])){
                prev = mp.get(nums[r]);
            }

            if(prev != -1){
                for(int l = 0; l <= prev; l++){
                    cumSum[l] -= val;
                }
            }

            for(int l = 0; l <= r; l++){
                cumSum[l] += val;
            }

            for(int l = 0; l <= r; l++){
                if(cumSum[l] == 0){
                    maxL = Math.max(maxL, r-l+1);
                    break;
                }
            }
            mp.put(nums[r], r);
        }

        return maxL;
    }
}


//Approach - 2 (Using Segment Tree RMin Max Query
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    int n;
    int[] segMin;
    int[] segMax;
    int[] lazy;

    void propagate(int i, int l, int r){
        if(lazy[i] != 0){
            segMin[i] += lazy[i];
            segMax[i] += lazy[i];

            if(l != r){
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }

            lazy[i] = 0;
        }
    }

    void updateRange(int start, int end, int i, int l, int r, int val){
        propagate(i, l, r);

        if(l > end || r < start) return;

        if(l >= start && r <= end){
            lazy[i] += val;
            propagate(i, l, r);
            return;
        }

        int mid = (l+r)/2;
        updateRange(start, end, 2*i+1, l, mid, val);
        updateRange(start, end, 2*i+2, mid+1, r, val);

        segMin[i] = Math.min(segMin[2*i+1], segMin[2*i+2]);
        segMax[i] = Math.max(segMax[2*i+1], segMax[2*i+2]);
    }

    int findLeftMostZero(int i, int l, int r){
        propagate(i, l, r);

        if(segMin[i] > 0 || segMax[i] < 0){
            return -1;
        }

        if(l == r){
            return l;
        }

        int mid = l + (r-l)/2;
        int leftResult = findLeftMostZero(2*i+1, l, mid);
        if(leftResult != -1){
            return leftResult;
        }

        return findLeftMostZero(2*i+2, mid+1, r);
    }

    public int longestBalanced(int[] nums) {
        n = nums.length;
        segMin = new int[4*n];
        segMax = new int[4*n];
        lazy = new int[4*n];

        int[] cumSum = new int[n];

        int maxL = 0;

        Map<Integer,Integer> mp = new HashMap<>();

        for(int r = 0; r < n; r++){
            int val = (nums[r] % 2 == 0) ? 1 : -1;

            int prev = -1;
            if(mp.containsKey(nums[r])){
                prev = mp.get(nums[r]);
            }

            if(prev != -1){
                updateRange(0, prev, 0, 0, n-1, -val);
            }

            updateRange(0, r, 0, 0, n-1, val);

            int l = findLeftMostZero(0, 0, n-1);
            if(l != -1)
                maxL = Math.max(maxL, r-l+1);

            mp.put(nums[r], r);
        }

        return maxL;
    }
}