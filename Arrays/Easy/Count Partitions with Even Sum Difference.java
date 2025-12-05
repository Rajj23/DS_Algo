// **************************************************************************** JAVA ************************************************************************

// Approach 1
// T.C: O(2N)
// S.C: O(N) {can be optimized by removing preSum array and inplace use preSum value}
class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        
        preSum[0] = nums[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1] + nums[i];
        }

        int count = 0;

        for(int i=0;i<n-1;i++){
            int first = preSum[i];
            int second = preSum[n-1] - first;

            if(Math.abs(first-second)%2==0){
                count++;
            }
        }

        return count;
    }
}

// Approach 2
// T.C: O(N)
// S.C: O(1)
class Solution {
    public int countPartitions(int[] nums){
        int totalSum = 0;
        int n = nums.length;

        for(int num:nums){
            totalSum += num;
        }

        if(totalSum%2==0){
            return n-1;
        }
        else{
            return 0;
        }
    }
}


// **************************************************************************** C++ ************************************************************************

// Approach 1
// T.C: O(2N)
// S.C: O(N) {can be optimized by removing preSum array and inplace use preSum value}
class Solution {
public:
    int countPartitions(vector<int>& nums) {
        int n = nums.size();
        int count = 0;
        vector<int> preSum(n);

        preSum[0] = nums[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1] + nums[i];
        }

        for(int i=0;i<n-1;i++){
            int first = preSum[i];
            int second = preSum[n-1] - first;
            if(abs(first-second)%2==0){
                count++;
            }
        }

        return count;
    }
};


// Approach 2
// T.C: O(N)
// S.C: O(1)
class Solution {
public:
    int countPartitions(vector<int>& nums) {
        int totalSum = 0;
        int n = nums.size();

        for(int &num : nums){
            totalSum += num;
        }

        if(totalSum%2==0){
            return n-1;
        }
        else{
            return 0;
        }
    }
};