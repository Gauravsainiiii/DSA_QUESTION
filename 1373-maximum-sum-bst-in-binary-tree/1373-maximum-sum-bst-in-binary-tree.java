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
    private static class NodeState {
        boolean isBST;
        int min;
        int max;
        int sum;

        NodeState(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    private int maxBstSum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxBstSum;
    }

    private NodeState traverse(TreeNode root) {
        
        if (root == null) {
            return new NodeState(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        
        NodeState left = traverse(root.left);
        NodeState right = traverse(root.right);

        
        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int currentSum = root.val + left.sum + right.sum;
            maxBstSum = Math.max(maxBstSum, currentSum);

        
            int currentMin = Math.min(root.val, left.min);
            int currentMax = Math.max(root.val, right.max);

            return new NodeState(true, currentMin, currentMax, currentSum);
        }


        return new NodeState(false, 0, 0, 0);
    }
}