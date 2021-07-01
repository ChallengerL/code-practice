package com.personal;

/**
 * 爬楼梯
 * @author liuxiaohan1
 * @date 2021-06-28 3:37 下午
 */
public class lc70 {

    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            if (i % 7 == 0) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

}
