// Approach 1(recursive)
// T.C: O(n)
// S.C: O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root,list);
        return list;
    }
    private void postorder(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }

        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }
}

// Approach 2(iteravtive using 2 stack)
// T.C: O(n)
// S.C: O(2n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;

        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root.val);

            if(root.left!=null){
                st1.push(root.left);
            }
            if(root.right!=null){
                st1.push(root.right);
            }
        }
        while(!st2.isEmpty()){
            list.add(st2.pop());
        }
        return list;
    }
}

// Approach 3(iteravtive using 1 stack)
// T.C: O(2n)
// S.C: O(n)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;

        TreeNode curr = root;
        TreeNode lastVist = null;

        while(curr!=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp  = st.peek();
                if(temp.right != null && lastVist != temp.right){
                    curr = temp.right;
                }
                else{
                    list.add(temp.val);
                    lastVist = st.pop();
                }
            }
        }
        return list;
    }
}