package com.personal;

import java.util.Arrays;

/**
 * 零钱兑换 lc518 lc70
 * @author liuxiaohan1
 * @date 2021-06-28 3:06 下午
 */
public class lc322 {

    public int coinChange(int[] coins, int amount) {
        // dp[i]表示组成金额 i 所需最少的硬币数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
