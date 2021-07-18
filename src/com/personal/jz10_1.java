package com.personal;

/**
 * 斐波那契数列
 * @author liuxiaohan1
 * @date 2021-07-16 11:23 上午
 */
public class jz10_1 {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0, b = 1, sum = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }

}
