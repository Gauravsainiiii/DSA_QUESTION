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
    private int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return maxLen;
    }

    private void dfs(TreeNode node, boolean isLeft, int currentLen) {
        if (node == null) return;
        
        maxLen = Math.max(maxLen, currentLen);
        
        if (isLeft) {
        
            dfs(node.right, false, currentLen + 1);
            dfs(node.left, true, 1);
        } else {
            
            dfs(node.left, true, currentLen + 1);
            dfs(node.right, false, 1);
        }
    }
}