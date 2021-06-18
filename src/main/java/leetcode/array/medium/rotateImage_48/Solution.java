package leetcode.array.medium.rotateImage_48;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        solution.rotate1(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     * 注意：通过4*4举例找到规律(i, j) -> (len - 1 - j, i)
     * 写代码时可以按照举例的规律编写：
     * (0, 0) = (3, 0)  (count, count + i) = (len - 1 - count - i, count)
     * (3, 0) = (3, 3)  (len - 1 - count - i, count) = (len - 1 - count, len - 1 - count - i)
     * (3, 3) = (0, 3)  (len - 1 - count, len - 1 - count - i) = (count + i, len - 1 - count)
     * (0, 3) = (0, 0)  (count + i, len - 1 - count) = (count, count + i)
     * 只要第一个没有错误的话，之后的按照交换的规则编写就行
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int len = matrix.length;
        int count = 0;
        while (count <= len / 2) {
            for (int i = 0; i < len - (count * 2) - 1; i++) {
                int tmp = matrix[count][i + count];
                matrix[count][i + count] = matrix[len - 1 - i - count][count];
                matrix[len - 1 - i - count][count] = matrix[len - 1 - count][len - 1 - i - count];
                matrix[len - 1 - count][len - 1 - i - count] = matrix[i + count][len - 1 - count];
                matrix[i + count][len - 1 - count] = tmp;
            }
            count++;
        }
    }

    /**
     * 先按照对角线进行翻转
     * 再水平对折
     */
    public void rotate1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        // 对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 水平对折
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = tmp;
            }
        }
    }
}
