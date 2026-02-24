//Approach - Recursion
//T.C : O(n)
//S.C : O(1) Auxiliary space (But O(n) system recursion stack space)
class Solution {
    int total = 0;
    void preOrder(TreeNode root, int val){
        if(root == null){
            return;
        }
        val = (val << 1) + root.val;

        if(root.left == null && root.right == null){
            total += val;
            return;
        }

        preOrder(root.left, val);
        preOrder(root.right, val);
    }
    public int sumRootToLeaf(TreeNode root) {
        preOrder(root, 0);
        return total;
    }
}

//Approach - Recursion
//T.C : O(n)
//S.C : O(1) Auxiliary space (But O(n) system recursion stack space)
class Solution {
    int preOrder(TreeNode root, int val){
        if(root == null){
            return 0;
        }
        val = (val << 1) + root.val;

        if(root.left == null && root.right == null){
            return val;
        }

        return preOrder(root.left, val) + preOrder(root.right, val);
    }
    public int sumRootToLeaf(TreeNode root) {
        return preOrder(root, 0);
    }
}