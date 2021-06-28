package com.personal;

/**
 * 零钱兑换2 lc322 lc70
 * @author liuxiaohan1
 * @date 2021-06-28 2:16 下午
 */
public class lc518 {

    public static int change(int amount, int[] coins) {
        // dp[x]表示金额总和为x的硬币组合数
        // amount = 5, coins = [1, 2, 5]
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount  = 5;
        int[] coins = new int[]{1,2,5};
        System.out.println(change(amount, coins));
    }

}
