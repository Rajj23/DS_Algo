// Similar question solved via segment tree
// T.C: O(m*root(n))
// S.C: O(n)
class NumArray {
    int[] nums;
    int[] blocks;
    int n;
    int blockSize;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;

        blockSize = (int) Math.ceil(Math.sqrt(n));
        blocks = new int[blockSize];

        for(int i = 0; i < n; i++){
            int blockIndex = i / blockSize;
            blocks[blockIndex] += nums[i];
        }
    }
    
    public void update(int index, int val) {
        int blockIndex = index / blockSize;

        blocks[blockIndex] -= nums[index];
        blocks[blockIndex] += val;
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;

        int startBlock = left / blockSize;
        int endBlock = right / blockSize;

        if(startBlock == endBlock){
            for(int i = left; i <= right; i++){
                sum += nums[i];
            }
            return sum;
        }

        int endIndexOfStartBlock = ((startBlock + 1) * blockSize) - 1;
        for(int i = left; i <= endIndexOfStartBlock; i++){
            sum += nums[i];
        }

        for(int b = startBlock+1; b <= endBlock-1; b++){
            sum += blocks[b];
        }

        int startIndexOfEndBlock = endBlock * blockSize;
        for(int i = startIndexOfEndBlock; i <= right; i++){
            sum += nums[i];
        }

        return sum;

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */