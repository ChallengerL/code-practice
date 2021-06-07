package com.personal;

/**
 * 买卖股票的最佳时机
 *
 * @author liuxiaohan1
 * @date 2021-06-07 20:30
 */
public class lc121 {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

}
