// T.C: O(log(n))
// S.C: O(1)
class Solution {
    int lowerBound(int[] nums, int target){
        int l = 0, r = nums.length-1;
        int ans = -1;
        
        while(l <= r){
            int mid = l + (r - l)/2;

            if(nums[mid] >= target){
                if(nums[mid] == target){
                    ans = mid;
                }
                r = mid -1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }

    int upperBound(int[] nums, int target){
        int l = 0, r = nums.length-1;
        int ans = -1;
        
        while(l <= r){
            int mid = l + (r - l)/2;

            if(nums[mid] <= target){
                if(nums[mid] == target){
                    ans = mid;
                }
                l = mid + 1;
            }
            else{
                r = mid-1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        // if(nums.length < 1) return new int[]{-1, -1};
        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target);

        return new int[]{lower, upper};
    }
}