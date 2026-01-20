// Approach: 1 (recursive)
// T.C: O(n)
// S.C: O(n)
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}


// Approach: 2 (morris traversal)
// T.C: O(n)
// S.C: O(1)
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while(curr != null){
            if(curr.left != null){
                TreeNode prev = curr.left;

                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}