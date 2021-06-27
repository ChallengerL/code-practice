package com.personal;

/**
 * 统计全为 1 的正方形子矩阵 lc221
 * @author liuxiaohan1
 * @date 2021-06-27 3:42 下午
 */
public class lc1277 {

    public int countSquares(int[][] matrix) {
        int ans = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }

}
