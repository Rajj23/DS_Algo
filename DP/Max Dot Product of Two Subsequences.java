//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    int m, n;
    int t[][];

    int solve(int[] nums1, int[] nums2, int i, int j){
        if(i == m || j == n){
            return (int)-1e9;
        }

        if(t[i][j] != (int)-1e9){
            return t[i][j];
        }
        int val = nums1[i] * nums2[j];

        int take_i_j = (nums1[i]*nums2[j] + solve(nums1,nums2,i+1,j+1));

        int take_i = solve(nums1,nums2, i, j+1);

        int take_j = solve(nums1,nums2,i+1,j);

        return t[i][j] = Math.max(val, Math.max(take_i_j, Math.max(take_i, take_j)));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;

        t = new int[501][501];

        for(int i=0;i<501;i++){
            for(int j=0;j<501;j++){
                t[i][j] = (int) -1e9;
            }
        }

        return solve(nums1,nums2,0,0);
    }
}