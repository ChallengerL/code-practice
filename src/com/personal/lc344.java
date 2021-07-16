package com.personal;

/**
 * 反转字符串
 * @author liuxiaohan1
 * @date 2021-07-15 10:26 上午
 */
public class lc344 {

    public void reverseString(char[] s) {
        int i = 0, j = s.length;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

}
