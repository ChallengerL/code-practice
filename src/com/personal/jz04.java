package com.personal;

/**
 * 二维数组的查找
 * @author liuxiaohan1
 * @date 2021-07-06 3:53 下午
 */
public class jz04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j <= matrix[0].length - 1) {
            if (target == matrix[i][j]) {
                return true;
            }
            if (target > matrix[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

}
