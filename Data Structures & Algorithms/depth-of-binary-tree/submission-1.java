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
    int depth = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root, depth);

        return depth;
    }

    public void dfs(TreeNode node, int currDepth) {
        if (node != null) {
            depth = Math.max(depth, ++currDepth);
            dfs(node.right, currDepth);
            dfs(node.left, currDepth);
        }
    }
}
