//T.C : Constructor: O(n), where n is length of nums array
//      Update, sumRange: O(logN)
//S.C : O(n)
class NumArray {
    int[] seg;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4*n];
        build(0, 0, n-1, nums);
    }

    void build(int idx, int left, int right, int[] nums){
        if(left == right){
            seg[idx] = nums[left];
            return; 
        }

        int mid = left + (right - left)/2;
        build(2*idx+1, left, mid, nums);
        build(2*idx+2, mid+1, right, nums);

        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }

    void updateUtil(int idx, int left, int right, int pos, int val){
        if(left == right){
            seg[idx] = val;
            return;
        }

        int mid = left + (right-left)/2;
        if(pos <= mid){
            updateUtil(idx*2+1, left, mid, pos, val);
        }
        else{
            updateUtil(idx*2+2, mid+1, right, pos, val);
        }

        seg[idx] = seg[idx*2+1] + seg[idx*2+2];
    }

    int queryUtil(int idx, int start, int end, int left, int right){
        if(right < start || end < left){
            return 0;
        }
        if(left >= start && right <= end){
            return seg[idx];
        }
        int mid = left + (right-left)/2;
        return queryUtil(idx*2+1, start, end, left, mid) +
                queryUtil(idx*2+2, start, end, mid+1, right);
    }
    
    public void update(int index, int val) {
        updateUtil(0,0,n-1, index, val);
    }
    
    public int sumRange(int start, int end) {
        return queryUtil(0, start, end, 0, n-1);
    }

}
