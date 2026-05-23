//Approach-1 (Super Brute Force)
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int[] sorted = new int[n];

        for(int r = 0; r < n; r++){

            int idx = 0;
            for(int i = r; i < n; i++){
                sorted[idx] = nums[i];
                idx++;
            }

            for(int i = 0; i < r; i++){
                sorted[idx] = nums[i];
                idx++;
            }

            boolean isSorted = true;
            for(int i = 0; i < n-1; i++){
                if(sorted[i] > sorted[i+1]){
                    isSorted = false;
                    break;
                }
            }
            if(isSorted) return true;
        }

        return false;
    }
}


//Approach-2 (Better Brute Force)
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for(int r = 0; r < n; r++){
            boolean isSorted = true;
            for(int i = 0; i < n; i++){
                if(sorted[i] != nums[(i+r)%n]){
                    isSorted = false;
                    break;
                }
            }

            if(isSorted) return true;
        }

        return false;
    }
}


//Approach-3 (Optimal)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int peak = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] > nums[(i+1)%n]){
                peak++;
            }
        }

        return peak > 1 ? false : true;
    }
}