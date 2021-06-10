package com.personal;

/**
 * 圆环回原点问题
 * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 *
 * 输入: 2
 * 输出: 2
 * 解释：有2种方案。分别是0->1->0和0->9->0
 *
 * @author liuxiaohan1
 * @date 2021-06-10 20:16
 */
public class additional2 {

    public int backToOrigin(int n, int length) {
        int[][] dp = new int[n + 1][length];
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length];
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        additional2 additional2 = new additional2();
        System.out.println(additional2.backToOrigin(2, 10));
    }

}
