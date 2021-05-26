package leetcode.tree.easy.balancedBinaryTree_110;

import leetcode.tree.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        t4.right = t7;
        t6.left = t8;
        t8.left = t9;
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(t1));
    }

    /**
     * 方法一：递归高级版（从底到顶）
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        // 首先获取当前节点最左边的节点的高度
        int leftHeight = getHeight(root.left);
        // 判断左子树是否符合平衡二叉树的定义
        if (leftHeight == -1) {
            return -1;
        }
        // 然后获取当前节点最右边的节点的高度
        int rightHeight = getHeight(root.right);
        // 判断右子树是否符合平衡二叉树的定义
        if (rightHeight == -1) {
            return -1;
        }
        // 判断当前节点的高度是否符合平衡二叉树的定义，如果不符合，直接返回-1，停止递归
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 如果已经遍历的节点符合平衡二叉树的定义，那么返回当前子树的高度
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /**
     * 方法二：递归
     * 时间复杂度O(n lgn)，最坏的时间复杂度为O(n2)（当树退化为链表时）
     * 空间复杂度O(n)
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) return true;
        int leftHeight = getHeight1(root.left);
        int rightHeight = getHeight1(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int getHeight1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
