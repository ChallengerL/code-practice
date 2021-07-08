package com.personal;

/**
 * x的n次幂
 * @author liuxiaohan1
 * @date 2021-07-08 8:20 下午
 */
public class lc50 {

    public double myPow(double x, int n) {
        long m = n;
        if (m < 0) {
            x = 1/ x;
            m = -m;
        }
        double res = 1;
        while (m > 0) {
            if ((m & 1) == 0) {
                res *= x;
            }
            x *= x;
            m >>= 1;
        }
        return res;
    }

}
