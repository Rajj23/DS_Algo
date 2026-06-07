// Approach: 1
// T.C: O(n + (p + c))
// S.C: O(n)
class Solution {
    TreeNode solve(int root, Map<Integer, Integer> leftChild, Map<Integer, Integer> rightChild){

        TreeNode node = new TreeNode(root);
        if(leftChild.containsKey(root)){
            int child = leftChild.get(root);
            node.left = solve(child, leftChild, rightChild);
        }
        if(rightChild.containsKey(root)){
            int child = rightChild.get(root);
            node.right = solve(child, leftChild, rightChild);
        }

        return node;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Integer> leftChild = new HashMap<>();
        Map<Integer, Integer> rightChild = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        int root = -1;

        for(int[] description : descriptions){
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];

            children.add(child);

            if(root == child){
                root = parent;
            }

            if(isLeft == 1){
                leftChild.put(parent, child);
            }
            else{
                rightChild.put(parent, child);
            }
        }

        for(int[] description : descriptions){
            if(!children.contains(description[0])){
                root = description[0];
            }
        }

        TreeNode head = solve(root, leftChild, rightChild);
        return head;
    }
}


// Approach: 2 (creating tree while traversing)
// T.C: O(n)
// S.C: O(n)
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> mp = new HashMap<>();
        Set<Integer> st = new HashSet<>();

        for(int[] description : descriptions){
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];

            st.add(child);
            mp.putIfAbsent(parent, new TreeNode(parent));
            mp.putIfAbsent(child, new TreeNode(child));

            if(isLeft == 1){
                mp.get(parent).left = mp.get(child);
            }
            else{
                mp.get(parent).right = mp.get(child);
            }

        }

        for(int[] description : descriptions){
            if(!st.contains(description[0])){
                return mp.get(description[0]);
            }
        }

        return null;
    }
}