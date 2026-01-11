// T.C: O(n)
// S.C: O(h)
class Solution {
    public boolean checkTree(TreeNode root) {
        if(root == null) return true;

        if(root.left == null && root.right == null) return true;

        int l = (root.left != null) ? root.left.val : 0;
        int r = (root.right != null) ? root.right.val : 0;

        if(root.val != l+r){
            return false;
        }

        return checkTree(root.left) && checkTree(root.right);
    }
}