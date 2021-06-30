package com.personal;

/**
 * 字符转整数（atoi）
 *
 * int 变量正数和负数的范围不一致
 * int 变量正数和负数的范围是不一致的, int 的范围是  ~ , 即 -2147483648 ~ 2147483647, 正数和负数的范围是不一致的.
 * 我们在解析负数的时候, 是使用一个 int 值 result 和 boolean 值 negative 组合来完成最后数值的解析的.
 * 如果我们要解析的数是 -2147483648, 那么, 在解析的过程中, 需要存储一个 2147483648 的值, 那么直接用 int 存储 2147483648, 会发生溢出.
 * 因此这里的解决方案是, 使用负数来进行存储, 避免溢出.
 *
 * @author liuxiaohan1
 * @date 2021-06-30 8:49 下午
 */
public class lc8 {

    public int myAtoi(String s) {
        int result = 0;
        boolean negative = false; // 判断正负号的标记，先初始化为正
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE; // 所能解析数的最大范围，使用负数形式存储
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
                    limit = Integer.MIN_VALUE; // 如果是负值的话，重新制定限制范围
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
                if (digit < 0) { // 当前位非数字，直接返回此时的result
                    return negative ? result : -result;
                }
                if (result < multmin) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result *= 10;
                if (result < limit + digit) { // 判断增加了当前值之后会不会越界
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= digit; // 添加当前数值，注意我们是使用负数存储的，所以用减形式，通过上面代码，保证到这一步一定不会发生溢出
            }
        } else {
            return 0;
        }
        return negative ? result : -result;
    }

}
