// T.C: O(n)
// S.C: O(1)
class Solution {
    private TreeNode prev, first, mid, last;

    void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
                mid = root;
            }
            else{
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        if(root == null) return;

        first = mid = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(last != null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else{
            int t = first.val;
            first.val = mid.val;
            mid.val = t;
        }
    }
}