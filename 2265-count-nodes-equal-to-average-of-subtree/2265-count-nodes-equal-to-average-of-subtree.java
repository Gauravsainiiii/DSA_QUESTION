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
    private int matchingNodeCount = 0;

    public int averageOfSubtree(TreeNode root) {
        calculateSubtreeStats(root);
        return matchingNodeCount;
    }

    
    private int[] calculateSubtreeStats(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; 
        }

        
        int[] leftStats = calculateSubtreeStats(node.left);
        int[] rightStats = calculateSubtreeStats(node.right);

        
        int currentSum = leftStats[0] + rightStats[0] + node.val;
        int currentCount = leftStats[1] + rightStats[1] + 1;


        if (node.val == currentSum / currentCount) {
            matchingNodeCount++;
        }

        return new int[]{currentSum, currentCount};
    }
}