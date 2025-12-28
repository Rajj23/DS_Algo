// T.C: O(n)
// S.C: O(1) (but auxilary space would be n)
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh,rh);
    }
}