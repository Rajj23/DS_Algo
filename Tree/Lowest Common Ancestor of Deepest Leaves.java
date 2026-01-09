// T.C: O(n)
// S.C: O(maxD)
class Solution {
    Map<Integer,Integer> mp = new HashMap<>();
    int maxD = 0;

    TreeNode LCA(TreeNode root){
        if(root == null || mp.get(root.val) == maxD){
            return root;
        }

        TreeNode l = LCA(root.left);
        TreeNode r = LCA(root.right);

        if(l != null && r!= null){
            return root;
        }

        return l != null ? l : r;
    }
    
    void depth(TreeNode root, int d){
        if(root == null){
            return;
        }

        maxD = Math.max(maxD,d);
        mp.put(root.val,d);

        depth(root.left, d+1);
        depth(root.right, d+1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root, 0);

        return LCA(root);
    }
}