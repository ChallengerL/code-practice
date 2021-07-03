package com.personal;

/**
 * 螺旋矩阵2
 * @author liuxiaohan1
 * @date 2021-07-03 2:17 下午
 */
public class lc59 {

    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] matrix = new int[n][n];
        int num = 1;
        while (num <= n * n) {
            for (int i = l; i <= r; i++) {
                matrix[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                matrix[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                matrix[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }
        return matrix;
    }

}
