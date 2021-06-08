package com.personal;

/**
 * x 的平方根：牛顿迭代法
 *
 * @author liuxiaohan1
 * @date 2021-06-08 20:53
 */
public class lc69 {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        double c = x, x0 = x;
        while (true) {
            double xi = 0.5 * (c / x0 + x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }

}
