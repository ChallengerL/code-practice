package com.personal;

/**
 * 买卖股票的最佳时机-Ⅱ（多次买卖）
 *
 * @author liuxiaohan1
 * @date 2021-06-10 18:28
 */
public class lc122 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }

}
