package com.personal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @description:
 * @author: liuXiaoHan
 * @date: 2021-09-26 21:08
 **/
public class tx3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        StringBuilder str = new StringBuilder();
        str.append(s);
        while (true) {
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '@') {
                    have(str);
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                num = num * 10 + str.charAt(i) - '0';
            }
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != ' ' || i == str.length() - 1) {
                switch (preSign) {
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*' :
                        stack.push(stack.pop() * num);
                        break;
                }
                preSign = str.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        System.out.println(res);
    }

    public static StringBuilder have(StringBuilder str) {
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '@') {
                flag = false;
                int left = i - 1, right = i + 1;
                int left_num = 0, right_num = 0;
                while (Character.isDigit(str.charAt(left))) {
                    left--;
                    if (left < 0) {
                        break;
                    }
                }
                left++;
                left_num = Integer.parseInt(str.substring(left, i));
                while (Character.isDigit(str.charAt(right))) {
                    right++;
                    if (right == str.length()) {
//                        right--;
                        break;
                    }
                }
//               right;
                right_num = Integer.parseInt(str.substring(i + 1, right));
//                System.out.println(left_num);
//                System.out.println(right_num);
                int replace = left_num | (left_num + right_num);
//                System.out.println(replace);
                str.replace(left, right, String.valueOf(replace));
//                System.out.println(str);
            }
        }
        return str;
    }
}
