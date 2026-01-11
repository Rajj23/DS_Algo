// T.C: O(2n)
// S.C: O(n)
class Solution {
    void markParent(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parent_track.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                parent_track.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParent(root, parent_track, target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target,true);
        int currLevel = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(currLevel == k) break;
            currLevel++;

            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if(parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null){
                    q.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            result.add(curr.val);
        }
        return result;
    }
}