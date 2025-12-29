// T.C: O(n)
// S.C: O(1)
class Solution {
    int maxi = 0;
    private int findMax(TreeNode root){
        if(root==null) return 0;

        int lm = findMax(root.left);
        int rm = findMax(root.right);

        maxi = Math.max(maxi,lm+rm);

        return 1+Math.max(lm,rm);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return maxi;
    }
}