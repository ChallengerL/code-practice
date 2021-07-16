package com.personal;

/**
 * 位 1 的个数
 * @author liuxiaohan1
 * @date 2021-07-15 10:23 上午
 */
public class lc191 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n -  1);
            res++;
        }
        return res;
    }

}
