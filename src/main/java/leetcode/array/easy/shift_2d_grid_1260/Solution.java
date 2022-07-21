package leetcode.array.easy.shift_2d_grid_1260;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.shiftGrid(grid, 1));
    }


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int i = 0; i < k; i++) {
            int tmp = grid[grid.length - 1][grid[grid.length- 1].length - 1];
            for (int m = grid.length - 1; m >= 0; m--) {
                for (int n = grid[m].length - 1; n >= 0; n--) {
                    if (m == 0 && n == 0) {
                        grid[m][n] = tmp;
                    } else if (n == 0) {
                        grid[m][0] = grid[m - 1][grid[m - 1].length - 1];
                    } else {
                        grid[m][n] = grid[m][n - 1];
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int m = 0; m < grid.length; m++) {
            List<Integer> tmp = new ArrayList<>();
            for (int n = 0; n < grid[m].length; n++) {
                tmp.add(grid[m][n]);
            }
            res.add(tmp);
        }
        return res;
    }
}
