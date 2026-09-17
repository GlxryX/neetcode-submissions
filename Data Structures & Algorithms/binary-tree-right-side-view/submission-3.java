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
    List<Integer> list = new ArrayList<>();
    int currLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return list;
        list.add(root.val);
        dfs(root, currLevel);
        return list;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level > currLevel) {
            list.add(node.val);
            ++currLevel;
        }
        
        dfs(node.right, ++level);
        dfs(node.left, level);
    }
}
