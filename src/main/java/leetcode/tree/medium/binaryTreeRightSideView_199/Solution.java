package leetcode.tree.medium.binaryTreeRightSideView_199;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
//        [1,2,3,null,5,null,4,6,7,8,9,10,null]
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        Solution s = new Solution();
        System.out.println(s.rightSideView1(t1));
    }

    /**
     * 层次遍历
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode tmpNode = queue.poll();
                if (tmpNode.left != null) queue.offer(tmpNode.left);
                if (tmpNode.right != null) queue.offer(tmpNode.right);
                if (i == 1) res.add(tmpNode.val);
            }
        }
        return res;
    }

    /**
     * 深度优先遍历
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res, int depth) {
        if (node == null) return;
        if (res.size() == depth) {
            res.add(node.val);
        }
        depth++;
        dfs(node.right, res, depth);
        dfs(node.left, res, depth);
    }
}
