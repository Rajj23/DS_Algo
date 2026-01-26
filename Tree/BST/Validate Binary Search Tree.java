// T.C: O(log(n))
// S.C: O(1)
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long minVal, long maxVal){
        if(root == null) return true;
        if(root.val <= minVal || root.val >= maxVal){
            return false;
        }

        return isValid(root.left, minVal, root.val) && isValid(root.right, root.val, maxVal);
    }
}