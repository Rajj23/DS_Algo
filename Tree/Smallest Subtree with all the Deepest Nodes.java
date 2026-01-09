// Approach-1 (Using 1 Pass Solution)
// T.C : O(n)
// S.C : O(maxDepth) System stack space
class Solution {
    class Pair{
        int depth;
        TreeNode node;
        Pair(int depth, TreeNode node){
            this.depth = depth;
            this.node = node;
        }
    }

    private Pair solve(TreeNode root){
        if(root == null){
            return new Pair(0, null);
        }

        Pair l = solve(root.left);
        Pair r = solve(root.right);

        if(l.depth == r.depth){
            return new Pair(l.depth+1, root);
        }
        else if(l.depth > r.depth){
            return new Pair(l.depth+1, l.node);
        }
        else{
            return new Pair(r.depth+1, r.node);
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return solve(root).node;
    }
}