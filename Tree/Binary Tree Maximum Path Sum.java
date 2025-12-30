// T.C: O(n)
// S.C: O(1)
class Solution {
    int result = Integer.MIN_VALUE;

    private int findMax(TreeNode root){
        if(root==null) return 0;

        int ls = Math.max(0, findMax(root.left));
        int rs = Math.max(0, findMax(root.right));

        int maxNode = root.val + ls + rs;
        result = Math.max(result, maxNode);
        
        return Math.max(ls + root.val, rs + root.val);
    }
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return result;
    }
}