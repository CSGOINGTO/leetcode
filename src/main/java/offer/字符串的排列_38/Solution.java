package offer.字符串的排列_38;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.permutation2("abc")));
    }

    /**
     * 回溯，中间进行了剪枝操作
     */
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        Set<String> res = new HashSet<>();
        dfs(s.toCharArray(), res, 0);
        return res.toArray(new String[0]);
    }

    private void dfs(char[] chars, Set<String> res, int x) {
        if (x == chars.length - 1) {
            res.add(new String(chars));
            return;
        }
        // 用来判断是否有重复的值，用来剪枝
        Set<Character> set = new HashSet<>();
        // 注意i = x，递归时可以拿到传进来的入参x的值
        for (int i = x; i < chars.length; i++) {
            // 如果存在的话，则直接进入下次循环
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            // 交换i, x
            swap(chars, i, x);
            // 递归x + 1位置的值
            dfs(chars, res, x + 1);
            // 将i，x交换回来
            swap(chars, i, x);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }



    public String[] permutation2(String s) {
        if (s == null || s.length() == 0) return null;
        HashSet<String> res = new HashSet<>();
        backtrack(s.toCharArray(), res, "", new boolean[s.length()]);
        return res.toArray(new String[0]);
    }

    private void backtrack(char[] chars, Set<String> res, String tmpStr, boolean[] visited) {
        //终止条件(递归必须要有终止条件)
        if (tmpStr.length() == chars.length) {
            //一些逻辑操作（可有可无，视情况而定）
            res.add(tmpStr);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            // 用于控制哪个char可以被加入到tmpStr
            visited[i] = true;
            //递归
            backtrack(chars, res, tmpStr + chars[i], visited);
            visited[i] = false;
        }
    }
}
