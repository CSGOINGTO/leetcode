package leetcode.tree.medium.pathSum_II_113;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // 5,4,8,11,null,13,4,7,2,null,null,5,1
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.left = t7;
        t4.right = t8;
        t3.left = t5;
        t3.right = t6;
        t6.left = t9;
        t6.right = t10;
        Solution solution = new Solution();
        System.out.println(solution.pathSum(t1, 22));

    }

    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs1(root, targetSum, res, new ArrayList<>());
        return res;
    }

    private void dfs1(TreeNode node, int target, List<List<Integer>> res, List<Integer> tmpList) {
        if (node == null) {
            return;
        }
        tmpList.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(tmpList));
            tmpList.remove(tmpList.size() - 1);
            return;
        }
        dfs1(node.left, target, res, tmpList);
        dfs1(node.right, target, res, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> tmpList = new ArrayList<>();
        dfs(root, targetSum, res, tmpList);
        return res;
    }

    private void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> tmpList) {
        if (root == null) {
            return;
        }
        if (target - root.val == 0 && root.left == null && root.right == null) {
            tmpList.add(root.val);
            res.add(new ArrayList<>(tmpList));
            tmpList.remove(tmpList.size() - 1);
            return;
        }
        if (root.left != null) {
            tmpList.add(root.val);
            dfs(root.left, target - root.val, res, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
        if (root.right != null) {
            tmpList.add(root.val);
            dfs(root.right, target - root.val, res, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
