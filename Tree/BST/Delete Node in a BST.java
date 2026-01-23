// T.C: O(H)
// S.C: O(1)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key){
            return insert(root);
        }

        TreeNode dummy = root;

        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = insert(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right.val == key){
                    root.right = insert(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    TreeNode insert(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }

        TreeNode rootRightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rootRightChild;
        return root.left;
    }

    TreeNode findLastRight(TreeNode root){
        if(root.right == null){
            return root;
        }
        return findLastRight(root.right);
    }
}