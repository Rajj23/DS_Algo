// Approach 1
// T.C : O(N*N)
// S.C : O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        for(int i=0;i<n;i++){
            int zeros = 0;
            for(int j=i;j<n;j++){
                if(nums[j]==0){
                    zeros++;
                }
                if(zeros<=k){
                    int len = j-i+1;
                    maxLen = Math.max(maxLen,len);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
}


// Approach 2
// T.C : O(2N)
// S.C : O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        // int l=0,r=0,maxLen=0;
        // int zeros=0;
        // while(r<nums.length){
        //     if(nums[r]==0) zeros++;

        //     while(zeros>k){
        //         if(nums[l]==0) zeros--;
        //         l++;
        //     }

        //     if(zeros<=k){
        //         int len = r-l+1;
        //         maxLen = Math.max(maxLen,len);
        //     }
        //     r++;
        // }
        // return maxLen;

    }
}


// Approach 3
// T.C : O(N)
// S.C : O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,maxLen=0;
        int zeros=0;

        while(r<nums.length){
            if(nums[r]==0) zeros++;

            if(zeros>k){
                if(nums[l]==0) zeros--;
                l++;
            }

            if(zeros<=k){
                int len = r-l+1;
                maxLen = Math.max(maxLen,len);
            }
            r++;
        }
        return maxLen;
    }
}