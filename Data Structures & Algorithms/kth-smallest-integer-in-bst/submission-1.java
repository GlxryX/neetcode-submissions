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
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return root.val;
        pq.add(root.val);
        dfs(root.left);
        dfs(root.right);

        while (k > 0) {
            if (k == 1) return pq.poll();
            pq.poll();
            --k;
        }

        return -1;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        pq.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
