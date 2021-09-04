package com.personal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 移掉 k 位数字
 * @author liuxiaohan1
 * @date 2021-08-31 5:41 下午
 */
public class lc402 {

    public static String removeKdigits(String num, int k) {

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && c < deque.peekLast()) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
//        System.out.println(deque);
        boolean flag = true;
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            Character c = deque.pollFirst();
            if (flag && c == '0') {
                continue;
            }
            flag = false;
            res.append(c);
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    public static void main(String[] args) {

        String num = "100001";
        String s = removeKdigits(num, 1);
        System.out.println(s);
    }

}
