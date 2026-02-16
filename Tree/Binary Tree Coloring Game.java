// T.C: O(n)
// S.C: O(1)
class Solution {
    TreeNode target;
    void findTarget(TreeNode root, int x){
        if(root == null) return;

        if(root.val == x){
            target = root;
            return;
        }

            findTarget(root.left, x);

            findTarget(root.right, x);
    }

    int height(TreeNode root){
        if(root == null) return 0;

        return height(root.left) + height(root.right)+1;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        findTarget(root, x);

        int lh = height(target.left);
        int rh = height(target.right);

        int par = n - (lh + rh + 1);

        int max = Math.max(lh, Math.max(rh, par));

        return max > n/2;
    }
}