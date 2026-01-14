// Approach: 1
// T.C: O(n)
// S.C: O(n)
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            count += size;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }

        return count;
    }
}


// Approach: 2
// T.C: O(n)
// S.C: O(log(n))
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return 1 + left + right;
    }
}


// Approach: 3
// T.C: O((log(n))^2)
// S.C: O(log(n))
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int left = getHeightLeft(root);
        int right = getHeightRight(root);

        if(left == right) return ((2<<(left)) - 1);

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getHeightLeft(TreeNode root){
        int count = 0;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }

    private int getHeightRight(TreeNode root){
        int count = 0;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
}