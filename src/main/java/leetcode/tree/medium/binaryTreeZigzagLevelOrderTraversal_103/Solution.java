package leetcode.tree.medium.binaryTreeZigzagLevelOrderTraversal_103;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                if (flag) {
                    list.addFirst(tmpNode.val);
                } else {
                    list.add(tmpNode.val);
                }
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
}
