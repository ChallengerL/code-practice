package com.personal;

/**
 * 最长重复子数组
 * @author liuxiaohan1
 * @date 2021-07-01 2:16 下午
 */
public class lc718 {

    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // dp[i][j]表示长度为i，末尾项为A[i-1]的子数组，
        // 与长度为j，末尾项为B[j-1]的子数组，二者的最大公共后缀子数组长度。
//        base case：如果i==0||j==0，则二者没有公共部分，dp[i][j]=0
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

}
