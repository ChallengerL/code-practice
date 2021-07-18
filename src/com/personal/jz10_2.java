package com.personal;

/**
 * 青蛙跳台阶问题
 * @author liuxiaohan1
 * @date 2021-07-17 5:02 下午
 */
public class jz10_2 {

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1, b = 1, sum = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }

}
