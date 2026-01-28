// T.C: O(n)
// S.C: O(1)
class NodeValue{
    public int maxNode, minNode, maxSize;
    
    NodeValue(int minNode, int maxNode, int maxSize){
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}
class Solution {

    // Return the size of the largest sub-tree which is also a BST
    static NodeValue largestBSTSubtreeHelper(Node root){
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);
        
        if(left.maxNode < root.data && root.data < right.minNode){
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
                                    left.maxSize + right.maxSize + 1);
        }
        
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 
                            Math.max(left.maxSize, right.maxSize));
    }
    
    static int largestBst(Node root) {
        // Write your code here
        return largestBSTSubtreeHelper(root).maxSize;
    }
}