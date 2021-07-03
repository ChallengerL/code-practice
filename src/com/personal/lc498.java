package com.personal;

/**
 * 对角线遍历
 * @author liuxiaohan1
 * @date 2021-07-03 2:40 下午
 */
public class lc498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[]{};
        }
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int r = 0, c = 0;
        boolean flag = true;
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];
            if (flag) {
                if (c == n - 1) {
                    r++;
                    flag = false;
                } else if (r == 0) {
                    c++;
                    flag = false;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) {
                    c++;
                    flag = true;
                } else if (c == 0) {
                    r++;
                    flag = true;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return res;
    }

}
