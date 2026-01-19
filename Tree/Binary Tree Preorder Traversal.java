/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


// Approach: 1 (Recursive)
//T.C: O(n)
//S.C: O(n)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root,list);
        return list;
    }

    private void preOrder(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
}


// Approach: 2 (Iterative)
//T.C: O(n)
//S.C: O(n)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root==null){
            return result;
        }

        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            result.add(root.val);
            if(root.right!=null){
                st.push(root.right);
            }
            if(root.left!=null){
                st.push(root.left);
            }
        }
        return result;
    }
}



// Approach 3(Morris Traversal)
// T.C: O(n)
// S.C: O(1)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                result.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode leftChild = curr.left;

                while(leftChild.right != null && leftChild.right != curr){
                    leftChild = leftChild.right;
                }

                if(leftChild.right == null){
                    leftChild.right = curr;
                    result.add(curr.val);
                    curr = curr.left;
                }else{
                    leftChild.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}