package offer.二叉搜索树与双向链表_36;

import leetcode.tree.TreeNode;

public class Solution {
    private TreeNode pre, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
