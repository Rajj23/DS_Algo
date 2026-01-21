// T.C: O(log(n))
// S.C: O(1)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}