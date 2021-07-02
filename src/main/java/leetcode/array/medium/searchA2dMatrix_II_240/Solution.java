package leetcode.array.medium.searchA2dMatrix_II_240;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        };
        System.out.println(solution.searchMatrix(a, 5));
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length == 0) return false;
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column <= matrix[0].length - 1) {
            if (matrix[row][column] == target) return true;
            if (matrix[row][column] > target) {
                row--;
            } else {
                column++;
            }
        }
        return false;
    }
}
