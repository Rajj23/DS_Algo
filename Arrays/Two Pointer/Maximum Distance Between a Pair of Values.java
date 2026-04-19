// Approach: binary search (finding the max valid comination)
// T.C: O(m(log(n)))
// S.C: O(1)
class Solution {
    int search(int[] nums, int end, int tar){
        int n = nums.length;
        int low = 0;
        int high = Math.min(n-1, end);
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] > tar){
                low = mid + 1;
            }
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums2.length;
        int ans = 0;
        for(int j = 0; j < m; j++){
            int i = search(nums1, j, nums2[j]);
            if(i != -1){
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }
}

// Approach: 2-pointer
// T.C: O(m+n)
// S.C: O(1)
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;
        int result = 0;

        while(i < m && j < n){
            if(nums1[i] > nums2[j]){
                i++;
            }
            else{
                result = Math.max(result, j - i);
                j++;
            }
        }
        return result;
    }
}