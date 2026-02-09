// T.C: O(n)
// S.C: O(n)
class Solution {
    void preOrder(TreeNode root, List<TreeNode> list){
        if(root == null) return;

        preOrder(root.left, list);
        list.add(root);
        preOrder(root.right, list);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);


        return buildTree(list, 0, list.size()-1);
    }

    TreeNode buildTree(List<TreeNode> list, int start, int end){
        if(start > end) return null;

        int mid = start + (end-start)/2;

        TreeNode root = new TreeNode(list.get(mid).val);

        root.left = buildTree(list, start, mid-1);
        root.right = buildTree(list, mid+1, end);

        return root;
    }
}