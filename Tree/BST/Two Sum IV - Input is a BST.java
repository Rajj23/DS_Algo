// T.C: O(n)
// S.C: O(h)
class Solution {
    class BSTIterator{
        Stack<TreeNode> st = new Stack<>();
        boolean reverse = true;

        public BSTIterator(TreeNode root, boolean isReverse){
            reverse = isReverse;
            pushAll(root);
        }

        public int next(){
            TreeNode temp = st.pop();

            if(reverse == false){
                pushAll(temp.right);
            }
            else{
                pushAll(temp.left);
            }

            return temp.val;
        }

        public boolean hasNext(){
            return !st.isEmpty();
        }

        private void pushAll(TreeNode node){
            while(node != null){
                st.add(node);
                if(reverse){
                    node = node.right;
                }
                else{
                    node = node.left;
                }
            }
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while(i < j){
            if(i + j == k) 
                return true;
            else if(i + j > k) 
                j = r.next();
            else
                i = l.next();
        }

        return false;
    }
}