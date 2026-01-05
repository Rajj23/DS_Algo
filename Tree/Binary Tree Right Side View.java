// Approach 1 (using level order and maintaining height)
// T.C: O(n)
// S.C: O(n)
class Solution {
    class Pair{
        TreeNode node;
        int height;

        Pair(TreeNode node, int height){
            this.node = node;
            this.height = height;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> mp = new TreeMap<>();

        if(root == null) return list;

        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            Pair temp = q.poll();
            TreeNode node = temp.node;
            int height = temp.height;

            mp.put(height,node.val);

            if(node.left != null) q.add(new Pair(node.left, height+1));
            if(node.right != null) q.add(new Pair(node.right, height+1));
        }

        for(int val : mp.values()){
            list.add(val);
        }

        return list;
    }
}


// Approach 2 (using pre order and maintaining height)
// T.C: O(n)
// S.C: O(n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        solve(root, list, 0);
        return list;
    }

    private void solve(TreeNode root, List<Integer> list, int level){
        if(root == null) return;

        if(list.size() == level){
            list.add(root.val);
        }

        solve(root.right, list, level+1);
        solve(root.left, list, level+1);
    }
}
