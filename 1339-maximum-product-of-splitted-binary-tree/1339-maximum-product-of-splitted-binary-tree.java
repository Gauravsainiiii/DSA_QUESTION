/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private long totalSum = 0;
    private long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        
        totalSum = getTotalSum(root);


        findMaxProduct(root);


        return (int) (maxProduct % 1_000_000_007);
    }


    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }


    private long findMaxProduct(TreeNode node) {
        if (node == null) return 0;

        long leftSum = findMaxProduct(node.left);
        long rightSum = findMaxProduct(node.right);

        long currentSubtreeSum = node.val + leftSum + rightSum;

    
        long currentProduct = currentSubtreeSum * (totalSum - currentSubtreeSum);
        maxProduct = Math.max(maxProduct, currentProduct);

        return currentSubtreeSum;
    }
}