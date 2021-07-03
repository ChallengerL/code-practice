package com.personal;

/**
 * 搜索二维矩阵
 * @author liuxiaohan1
 * @date 2021-07-03 1:11 下午
 */
public class lc240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length - 1, n = 0;
        while (m >= 0 && n <= matrix[0].length - 1) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] < target) {
                n++;
            } else {
                m--;
            }
        }
        return false;
    }

}
