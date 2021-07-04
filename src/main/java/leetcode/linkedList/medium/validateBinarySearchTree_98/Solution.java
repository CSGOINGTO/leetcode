package leetcode.linkedList.medium.validateBinarySearchTree_98;

import leetcode.tree.TreeNode;

public class Solution {

    public static void main(String[] args) {
//        5
//                / \
//        1   4
//                / \
//        3   6
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        Solution solution = new Solution();
        System.out.println(solution.isValidBST(t1));

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return help(root, null, null);
    }

    public boolean help(TreeNode root, Integer max, Integer min) {
        if (root == null) return true;
        System.out.println("max: " + max + " ,min: " + min);
        if ((max != null && root.val >= max) || (min != null && root.val <= min)) return false;
        boolean left = help(root.left, root.val, min);
        boolean right = help(root.right, max, root.val);
        return left && right;
    }
}
