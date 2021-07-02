package com.personal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 基本计算器2
 * @author: liuXiaoHan
 * @date: 2021-07-03 00:03
 **/
public class lc227 {

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSingn = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                switch (preSingn) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                preSingn = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}
