package com.personal;

/**
 * 回文数
 * @author liuxiaohan1
 * @date 2021-07-08 8:34 下午
 */
public class lc9 {

    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int revert = 0;
        while (x > revert) {
            revert = revert * 10 + x % 10;
            x /= 10;
        }
        return x == revert || x == revert / 10;
    }

}
