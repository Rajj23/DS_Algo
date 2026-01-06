// Approach 1 (using BFS)
// T.C: O(n)
// S.C: O(n)
class Solution {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int minLevel = Integer.MAX_VALUE;
        int level = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int sum = 0;
            int size = q.size();
            level++;

            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                sum += temp.val;

                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }

            if(sum > maxSum){
                maxSum = sum;
                minLevel = level;
            }
        }
        return minLevel;
    }
}


// Approach 2 (using DFS)
// T.C: O(n)
// S.C: O(h)
class Solution {
    Map<Integer,Integer> mp = new TreeMap<>();

    void DFS(TreeNode root, int level){
        if(root == null){
            return;
        }

        mp.put(level, mp.getOrDefault(level,0) + root.val);

        DFS(root.left,level+1);
        DFS(root.right,level+1);
    }

    public int maxLevelSum(TreeNode root) {
        DFS(root,1);

        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            int level = entry.getKey();
            int sum = entry.getValue();

            if(sum > maxSum){
                maxSum = sum;
                resultLevel = level;
            }
        }

        return resultLevel;
    }
}