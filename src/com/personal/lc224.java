package com.personal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 基本计算器
 * @author liuxiaohan1
 * @date 2021-07-17 3:52 下午
 */
public class lc224 {

    public int calculate(String s) {
        // 栈顶记录当前符号，默认为正
        Deque<Integer> stack = new LinkedList<>();
        int sign = 1;
        stack.push(sign);

        int res = 0, num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
                continue;
            }
            res = res + sign * num;
            num = 0;
            if (s.charAt(i) == '+') {
                sign = stack.peek();
            } else if (s.charAt(i) == '-') {
                sign = -stack.peek();
            } else if (s.charAt(i) == '(') { // 进入左括号，把左括号之前的符号置于栈顶
                stack.push(sign);
            } else if (s.charAt(i) == ')') { // 退出括号，弹出栈顶符号
                stack.pop();
            }
        }
        res = res + sign * num; // 计算最后一个数
        return res;
    }

}
