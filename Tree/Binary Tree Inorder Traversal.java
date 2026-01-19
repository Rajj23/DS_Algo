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

// Approach 1(recursive)
// T.C: O(n)
// S.C: O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }

    void inorder(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}


// Approach 2(iterative)
// T.C: O(n)
// S.C: O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        if(root==null) return result;
        TreeNode node = root;

        while(true){
            if(node!=null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) break;

                node = st.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }
}


// Approach 3(Morris Traversal)
// T.C: O(n)
// S.C: O(1)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null){

            if(curr.left == null){
                result.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode leftChild = curr.left;

                while(leftChild.right != null){
                    leftChild = leftChild.right;
                }

                leftChild.right = curr;

                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        return result;
    }
}