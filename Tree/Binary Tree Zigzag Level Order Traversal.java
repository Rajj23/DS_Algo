// T.C: O(n)
// S.C: O(n)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new ArrayList<>();

            for(int i=0;i<size;i++){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                subList.add(q.poll().val);
            }

            if(!leftToRight){
                Collections.reverse(subList);
            }

            result.add(subList);

            leftToRight = !leftToRight;
        }

        return result;
    }
}