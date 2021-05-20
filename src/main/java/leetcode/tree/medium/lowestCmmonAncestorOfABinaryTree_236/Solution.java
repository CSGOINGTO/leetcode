package leetcode.tree.medium.lowestCmmonAncestorOfABinaryTree_236;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode res = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (dfs(node, p.val) && dfs(node, q.val)) {
                res = node;
            }
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return res;
    }

    private boolean dfs(TreeNode node, int val) {
        if (node == null) return false;
        if (node.val == val) return true;
        return dfs(node.left, val) || dfs(node.right, val);
    }
}
