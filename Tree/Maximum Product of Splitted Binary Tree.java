// T.C: O(n)
// S.C: O(n) if we consider recursion stack space, else O(1)
class Solution {
    long SUM = 0;
    long maxP = 0;

    long totalSum(TreeNode root){
        if(root == null){
            return 0;
        }

        long leftSubtreeSum = totalSum(root.left);
        long rightSubtreeSum = totalSum(root.right);
        long subTreeSum = root.val + leftSubtreeSum + rightSubtreeSum;

        long remainingSubTreeSum = SUM - subTreeSum;
        maxP = Math.max(maxP, subTreeSum * remainingSubTreeSum);

        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {
        if(root == null) return 0;

        SUM = totalSum(root);
        totalSum(root);

        return (int)(maxP%1_000_000_007);
    }
}