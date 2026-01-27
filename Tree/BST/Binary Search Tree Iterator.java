// T.C: O(n)
// S.C: O(h)
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();

        while(root != null){
            st.add(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode curr = st.pop();

        TreeNode temp = curr;
        if(temp.right != null){
            temp = temp.right;
            while(temp != null){
                st.push(temp);
                temp = temp.left; 
            }
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
