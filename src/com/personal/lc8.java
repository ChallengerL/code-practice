package com.personal;

/**
 * 字符转整数（atoi）
 * @author liuxiaohan1
 * @date 2021-06-30 8:49 下午
 */
public class lc8 {

    public int myAtoi(String s) {
        int result = 0;
        boolean negative = false; // 标记负号
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE; // 所能解析数的最大范围
        int multmin; // 在解析最后一位之前的最大范围
        int digit; // 所解析的每一位数字

        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }
        if (i < len) {
            char firstChar = s.charAt(i);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-'){
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                    return 0;
                }
                if (len == 1) { // Cannot have long "+" or "-"
                    return 0;
                }
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                digit = Character.digit(s.charAt(i++), 10);
                if (digit < 0) {
                    return negative ? result : -result;
                }
                if (result < multmin) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result *= 10;
                if (result < limit + digit) { // 判断增加了当前值之后会不会越界
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= digit; // 添加当前数值，注意我们是使用负数存储的，通过上面代码，保证到这一步一定不会发生溢出
            }
        } else {
            return 0;
        }
        return negative ? result : -result;
    }

}
